package com.natiqhaciyef.worldart.ui.fragment.registration.forgotpassword

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.usecase.firebase.ResetPasswordBySendingWebLinkFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val resetPasswordBySendingWebLinkFirebaseUseCase: ResetPasswordBySendingWebLinkFirebaseUseCase
) : BaseViewModel() {

    fun resetPassword(email: String) {
        viewModelScope.launch {

            resetPasswordBySendingWebLinkFirebaseUseCase.invoke(
                email = email,
                onSuccess = {},
                onFail = {}
            )

        }
    }
}