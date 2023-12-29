package com.natiqhaciyef.worldart.ui.fragment.registration.registration

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.databinding.FragmentRegisterBinding
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    private var toggle = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        register()
        navigateToSignIn()

        registerViewModel.state.observe(viewLifecycleOwner){
            println(it.isSuccessMessage)
            println(it.isFailMessage)
        }
    }


    private fun setup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.goToSignIn.text =
                Html.fromHtml(
                    getString(R.string.you_have_an_account),
                    Html.FROM_HTML_MODE_COMPACT
                )
        } else {
            binding.goToSignIn.text = Html.fromHtml(getString(R.string.you_have_an_account))
        }


        binding.visibilityIcon.setOnClickListener {
            if (toggle) {
                binding.passwordTextInputRegister.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                binding.visibilityIcon.setImageResource(R.drawable.visibility_off_icon)
            } else {
                binding.passwordTextInputRegister.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.visibilityIcon.setImageResource(R.drawable.visibility_icon)
            }

            toggle = !toggle
        }
    }

    private fun register() {
        binding.signUpButton.setOnClickListener {
            val username = binding.usernameTextInputRegister.text.toString()
            val email = binding.emailTextInputRegister.text.toString()
            val password = binding.passwordTextInputRegister.text.toString()

            val user = UserModel(
                name = username,
                email = email,
                password = password
            )

            registerViewModel.signUp(user)
        }
    }

    private fun navigateToSignIn(){
        binding.goToSignIn.setOnClickListener {
            navigate(R.id.loginFragment)
        }
    }
}