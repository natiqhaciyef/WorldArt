package com.natiqhaciyef.worldart.ui.fragment.registration.onboard

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.usecase.arch.GetAllArchitectureRemoteUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.CreateUserInFirebaseFirestoreUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.ResetPasswordBySendingWebLinkFirebaseUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignInFirebaseUseCase
import com.natiqhaciyef.worldart.domain.usecase.firebase.SignUpFirebaseUseCase
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(

) : BaseViewModel() {



}