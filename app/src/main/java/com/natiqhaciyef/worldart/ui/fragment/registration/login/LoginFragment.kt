package com.natiqhaciyef.worldart.ui.fragment.registration.login

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.natiqhaciyef.worldart.R
import com.natiqhaciyef.worldart.databinding.FragmentLoginBinding
import com.natiqhaciyef.worldart.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLEncoder

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private lateinit var binding: FragmentLoginBinding
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
}