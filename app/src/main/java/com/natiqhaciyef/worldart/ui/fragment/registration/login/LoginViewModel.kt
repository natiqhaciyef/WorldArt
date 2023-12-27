package com.natiqhaciyef.worldart.ui.fragment.registration.login

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignInFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInFirebaseUseCase: SignInFirebaseUseCase,
): BaseViewModel() {

    fun signIn(
        userModel: UserModel
    ) {
        viewModelScope.launch {
            signInFirebaseUseCase.invoke(
                email = userModel.email,
                password = userModel.password,
                onSuccess = {},
                onFail = {}
            )
        }
    }

}