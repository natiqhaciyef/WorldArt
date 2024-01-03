package com.natiqhaciyef.worldart.ui.base

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.ui.activity.MainActivity

open class BaseFragment : Fragment() {

    fun navigate(id: Int) {
        findNavController().navigate(id)
    }

    fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    fun navigate(deepLink: Uri) {
        requireActivity().startActivity(Intent(Intent.ACTION_VIEW, deepLink))
    }

    fun handleDeepLink(uri: String) {
        val destinationId = when (uri) {
            BaseNavigationDeepLink.ARCHITECTURE_MAIN_DEEPLINK -> R.id.arch_nav_graph
            else -> null // Handle invalid deep links
        }

        destinationId?.let { findNavController().navigate(it) }
    }


    fun navigate(activity: FragmentActivity, intent: Intent) {
        activity.startActivity(intent)
    }

    fun navigate(deepLink: Uri, navGraph: Int) {
        val pendingIntent = NavDeepLinkBuilder(requireContext())
            .setDestination(deepLink.toString())
            .createPendingIntent()

        pendingIntent.send()
    }

    fun generateSnackbar(title: String) {
        Snackbar.make(requireView(), title, Snackbar.LENGTH_LONG).show()
    }

    fun generateToast(title: String) {
        Toast.makeText(requireContext(), title, Toast.LENGTH_LONG).show()
    }
}