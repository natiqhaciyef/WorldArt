package com.natiqhaciyef.worldart.ui.fragment.registration.login

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.databinding.FragmentLoginBinding
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private var toggle = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        login()
        navigateToForgotPassword()
        navigateToSignUp()

        loginViewModel.state.observe(viewLifecycleOwner) {
            println(it.isSuccessMessage)
            println(it.isFailMessage)
        }
    }

    private fun setup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.goToSignUp.text =
                Html.fromHtml(
                    getString(R.string.you_don_t_have_an_account),
                    Html.FROM_HTML_MODE_COMPACT
                )
        } else {
            binding.goToSignUp.text = Html.fromHtml(getString(R.string.you_don_t_have_an_account))
        }


        binding.visibilityIcon.setOnClickListener {
            if (toggle) {
                binding.passwordTextInputLogin.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                binding.visibilityIcon.setImageResource(R.drawable.visibility_off_icon)
            } else {
                binding.passwordTextInputLogin.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.visibilityIcon.setImageResource(R.drawable.visibility_icon)
            }

            toggle = !toggle
        }
    }

    private fun login() {
        binding.signInButton.setOnClickListener {
            val email = binding.emailTextInputLogin.text.toString()
            val password = binding.passwordTextInputLogin.text.toString()

            val userModel = UserModel(
                name = "",
                email = email,
                password = password
            )

            loginViewModel.signIn(userModel)
        }
    }

    private fun navigateToForgotPassword() {
        binding.forgotPasswordText.setOnClickListener {
            super.navigate(R.id.forgotPasswordFragment)
        }
    }

    private fun navigateToSignUp() {
        binding.goToSignUp.setOnClickListener {
            super.navigate(R.id.registerFragment)
        }
    }
}
