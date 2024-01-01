package com.natiqhaciyef.worldart.ui.base

import android.net.Uri
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

open class BaseFragment : Fragment() {

    fun navigate(id: Int) {
        findNavController().navigate(id)
    }

    fun navigate(deepLink: Uri) {
        findNavController().navigate(deepLink)
    }

    fun generateSnackbar(title: String) {
        Snackbar.make(requireView(), title, Snackbar.LENGTH_LONG).show()
    }

    fun generateToast(title: String) {
        Toast.makeText(requireContext(), title, Toast.LENGTH_LONG).show()
    }
}