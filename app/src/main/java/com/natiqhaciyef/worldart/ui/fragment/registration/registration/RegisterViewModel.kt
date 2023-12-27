package com.natiqhaciyef.worldart.ui.fragment.registration.registration

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignUpFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val signUpFirebaseUseCase: SignUpFirebaseUseCase,
) : BaseViewModel() {

    fun signUp(
        userModel: UserModel
    ) {
        viewModelScope.launch {
            signUpFirebaseUseCase.invoke(
                username = userModel.name,
                email = userModel.email,
                password = userModel.password,
                onSuccess = {},
                onFail = {}
            )
        }
    }

}