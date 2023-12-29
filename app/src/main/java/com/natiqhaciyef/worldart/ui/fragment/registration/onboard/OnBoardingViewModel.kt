package com.natiqhaciyef.worldart.ui.fragment.registration.onboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.usecase.arch.GetAllArchitectureRemoteUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.CheckUseByEmailFirestoreUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.CreateUserInFirebaseFirestoreUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.ResetPasswordBySendingWebLinkFirebaseUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignInFirebaseUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignUpFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val checkUseByEmailFirestoreUseCase: CheckUseByEmailFirestoreUseCase
) : BaseViewModel() {
    private val _state = MutableLiveData(BaseUIState<String>())
    val state: LiveData<BaseUIState<String>>
        get() = _state

    fun isAuth(): Boolean {
        return auth.currentUser != null
    }

    fun isAuthStored() {
        val email = auth.currentUser?.email
        return checkUseByEmailFirestoreUseCase.invoke(
            email = email ?: "",
            onSuccess = {
                _state.value = _state.value?.copy(
                    isSuccessMessage = SuccessMessages.ONBOARDING_SUCCESS,
                    isSuccess = true,
                    isFailReason = null,
                    isFailMessage = null,
                    isFail = false,
                    isLoading = false
                )
            },
            onFail = {
                _state.value = _state.value?.copy(
                    isSuccessMessage = null,
                    isSuccess = false,
                    isFailReason = it,
                    isFailMessage = it?.localizedMessage,
                    isFail = true,
                    isLoading = false
                )
            }
        )
    }
}