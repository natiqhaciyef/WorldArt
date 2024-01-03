package com.natiqhaciyef.worldart.ui.fragment.registration.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.common.objects.ErrorMessages.SIGN_UP_FAILED
import com.natiqhaciyef.worldart.common.objects.ErrorMessages.WRONG_FILLED_ALL_INPUTS_REASON
import com.natiqhaciyef.worldart.common.objects.ErrorMessages.WRONG_FILLED_FIELD
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.usecase.firebase.LogOutUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignUpFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val signUpFirebaseUseCase: SignUpFirebaseUseCase,
    private val logOutUseCase: LogOutUseCase,
) : BaseViewModel() {
    private val _state = MutableLiveData(BaseUIState<String>())
    val state: LiveData<BaseUIState<String>>
        get() = _state

    fun signUp(
        userModel: UserModel
    ) {
        viewModelScope.launch {
            if (
                userModel.email.endsWith("@gmail.com")
                && userModel.password.length >= 8
            ) {
                signUpFirebaseUseCase.invoke(
                    username = userModel.name,
                    email = userModel.email,
                    password = userModel.password,
                    onSuccess = {
                        _state.value = _state.value?.copy(
                            isSuccess = true,
                            isFail = false,
                            isFailMessage = null,
                            isFailReason = null,
                            isSuccessMessage = SuccessMessages.SIGN_UP_SUCCESS,
                            isLoading = false,
                        )
                        logOut()
                    },
                    onFail = {
                        _state.value = _state.value?.copy(
                            isSuccess = false,
                            isFail = true,
                            isFailMessage = SIGN_UP_FAILED,
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
                    isFailMessage = "${WRONG_FILLED_FIELD}: $WRONG_FILLED_ALL_INPUTS_REASON",
                    isFailReason = Exception("${WRONG_FILLED_FIELD}: $WRONG_FILLED_ALL_INPUTS_REASON"),
                    isSuccessMessage = null,
                    isLoading = false,
                )
            }
        }
    }


    private fun logOut() {
        viewModelScope.launch {
            logOutUseCase.invoke()
        }
    }
}