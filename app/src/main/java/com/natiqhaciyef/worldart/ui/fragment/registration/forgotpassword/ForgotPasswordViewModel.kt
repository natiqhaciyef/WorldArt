package com.natiqhaciyef.worldart.ui.fragment.registration.forgotpassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.common.objects.ErrorMessages.WRONG_FILLED_EMAIL_INPUT_REASON
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.domain.usecase.firebase.ResetPasswordBySendingWebLinkFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val resetPasswordBySendingWebLinkFirebaseUseCase: ResetPasswordBySendingWebLinkFirebaseUseCase
) : BaseViewModel() {
    private val _state = MutableLiveData(BaseUIState<String>())
    val state: LiveData<BaseUIState<String>>
        get() = _state

    fun resetPassword(email: String) {
        viewModelScope.launch {
            if (email.endsWith("@gmail.com")) {
                resetPasswordBySendingWebLinkFirebaseUseCase.invoke(
                    email = email,
                    onSuccess = {
                        _state.value = _state.value?.copy(
                            isSuccess = true,
                            isFail = false,
                            isFailMessage = null,
                            isFailReason = null,
                            isSuccessMessage = SuccessMessages.RESET_PASSWORD_SUCCESS,
                            isLoading = false,
                        )
                    },
                    onFail = {
                        _state.value = _state.value?.copy(
                            isSuccess = false,
                            isFail = true,
                            isFailMessage = ErrorMessages.PASSWORD_RESETTING_FAILED,
                            isFailReason = it,
                            isSuccessMessage = null,
                            isLoading = false,
                        )
                    }
                )
            } else {
                _state.value = _state.value?.copy(
                    isSuccess = false,
                    isFail = true,
                    isFailMessage = WRONG_FILLED_EMAIL_INPUT_REASON,
                    isFailReason = Exception(WRONG_FILLED_EMAIL_INPUT_REASON),
                    isSuccessMessage = null,
                    isLoading = false,
                )
            }
        }
    }
}