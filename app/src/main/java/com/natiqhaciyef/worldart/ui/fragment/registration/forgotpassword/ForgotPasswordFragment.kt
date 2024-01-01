package com.natiqhaciyef.worldart.ui.fragment.registration.forgotpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.databinding.FragmentForgotPasswordBinding
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private val forgotPasswordViewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        send()
        forgotPasswordViewModel.state.observe(viewLifecycleOwner){
            navigateToLogin()
        }
    }

    private fun send() {
        binding.sendButton.setOnClickListener {
            val email = binding.emailTextInputReset.text.toString()
            forgotPasswordViewModel.resetPassword(email)
        }
    }

    private fun navigateToLogin() {
        if (forgotPasswordViewModel.state.value?.isSuccess == true) {
            navigate(R.id.loginFragment)
        } else if (forgotPasswordViewModel.state.value?.isFail == true) {
            generateToast(forgotPasswordViewModel.state.value?.isFailMessage ?: ErrorMessages.PASSWORD_RESETTING_FAILED)
        }
    }
}