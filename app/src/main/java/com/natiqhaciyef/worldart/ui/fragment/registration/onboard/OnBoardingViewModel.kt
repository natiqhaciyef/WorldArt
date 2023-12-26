package com.natiqhaciyef.worldart.ui.fragment.registration.onboard

import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.domain.usecase.arch.GetAllArchitectureRemoteUseCase
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val getAllArchitectureRemoteUseCase: GetAllArchitectureRemoteUseCase
) : BaseViewModel() {

    init {
        generatingTest()
    }

    fun generatingTest() {
        viewModelScope.launch {
            getAllArchitectureRemoteUseCase.invoke().collectLatest { result ->
                when (result.status) {
                    Status.LOADING -> {

                    }

                    Status.SUCCESS -> {
                        println(result.data)
                    }

                    Status.ERROR -> {
                        println(result.message)
                    }
                }
            }
        }
    }
}