package com.natiqhaciyef.worldart.ui.base

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    fun navigate(id: Int) {
        findNavController().navigate(id)
    }

    fun navigate(deepLink: Uri) {
        findNavController().navigate(deepLink)
    }
}