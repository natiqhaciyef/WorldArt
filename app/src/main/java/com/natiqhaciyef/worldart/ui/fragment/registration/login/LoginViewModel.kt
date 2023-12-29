package com.natiqhaciyef.worldart.ui.fragment.registration.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignInFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInFirebaseUseCase: SignInFirebaseUseCase,
) : BaseViewModel() {
    private val _state = MutableLiveData(BaseUIState<String>())
    val state: LiveData<BaseUIState<String>>
        get() = _state

    fun signIn(
        userModel: UserModel,
    ) {
        viewModelScope.launch {
            if (
                userModel.email.endsWith("@gmail.com")
                && userModel.password.length >= 8
            ) {
                signInFirebaseUseCase.invoke(
                    email = userModel.email,
                    password = userModel.password,
                    onSuccess = {
                        _state.value = _state.value?.copy(
                            isSuccess = true,
                            isFail = false,
                            isFailMessage = null,
                            isFailReason = null,
                            isSuccessMessage = SuccessMessages.SIGN_IN_SUCCESS,
                            isLoading = false,
                        )
                    },
                    onFail = {
                        _state.value = _state.value?.copy(
                            isSuccess = false,
                            isFail = true,
                            isFailMessage = ErrorMessages.SIGN_IN_FAILED,
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
                    isFailMessage = "${ErrorMessages.WRONG_FILLED_FIELD}: $WRONG_FILLED_ALL_INPUTS_REASON",
                    isFailReason = Exception("${ErrorMessages.WRONG_FILLED_FIELD}: $WRONG_FILLED_ALL_INPUTS_REASON"),
                    isSuccessMessage = null,
                    isLoading = false,
                )
            }
        }
    }
}