package com.natiqhaciyef.worldart.ui.fragment.registration.onboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.databinding.FragmentOnBoardingBinding
import com.natiqhaciyef.worldart.ui.activity.MainActivity
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OnBoardingFragment : BaseFragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private val onboardingViewModel: OnBoardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(2500)
            if (onboardingViewModel.isAuth()) {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                navigate(requireActivity(),intent)
            } else {
                navigate(R.id.loginFragment)
            }
        }
    }
}