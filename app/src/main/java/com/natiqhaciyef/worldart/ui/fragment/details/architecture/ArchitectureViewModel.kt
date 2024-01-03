package com.natiqhaciyef.worldart.ui.fragment.details.architecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.usecase.ad.GetAllAdsRemoteUseCase
import com.natiqhaciyef.worldart.domain.usecase.arch.GetAllArchitectureRemoteUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArchitectureViewModel @Inject constructor(
    private val getAllArchitectureRemoteUseCase: GetAllArchitectureRemoteUseCase,
    private val getAllAdsRemoteUseCase: GetAllAdsRemoteUseCase
) : BaseViewModel() {
    private val _archState = MutableLiveData(BaseUIState<UIResult<ArchitectureModel>>())
    val archState: LiveData<BaseUIState<UIResult<ArchitectureModel>>>
        get() = _archState

    private val _adsState = MutableLiveData(BaseUIState<UIResult<AdsModel>>())
    val adsState: LiveData<BaseUIState<UIResult<AdsModel>>>
        get() = _adsState



    init {
        getAllArchitecturePosts()
        getAllAds()
    }

    private fun getAllArchitecturePosts() {
        viewModelScope.launch {
            getAllArchitectureRemoteUseCase.invoke().collectLatest { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        if (result.data != null)
                            _archState.value = _archState.value?.copy(
                                data = if (result.data.isNotEmpty()) result.data.first() else null,
                                dataSet = result.data,
                                isLoading = false,
                                isFail = false,
                                isFailMessage = null,
                                isFailReason = null,
                                isSuccess = true,
                                isSuccessMessage = SuccessMessages.DATA_LOADED_SUCCESSFULLY
                            )
                    }

                    Status.ERROR -> {
                        _archState.value = _archState.value?.copy(
                            data = null,
                            dataSet = null,
                            isLoading = false,
                            isFail = true,
                            isFailMessage = result.message,
                            isFailReason = Exception(result.message),
                            isSuccess = false,
                            isSuccessMessage = null
                        )
                    }
                    Status.LOADING -> {
                        _archState.value = _archState.value?.copy(
                            data = null,
                            dataSet = null,
                            isLoading = true,
                            isFail = false,
                            isFailMessage = null,
                            isFailReason = null,
                            isSuccess = false,
                            isSuccessMessage = null
                        )
                    }
                }
            }
        }
    }

    private fun getAllAds() {
        viewModelScope.launch {
            getAllAdsRemoteUseCase.invoke().collectLatest { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        if (result.data != null)
                            _adsState.value = _adsState.value?.copy(
                                data = if (result.data.isNotEmpty()) result.data.first() else null,
                                dataSet = result.data,
                                isLoading = false,
                                isFail = false,
                                isFailMessage = null,
                                isFailReason = null,
                                isSuccess = true,
                                isSuccessMessage = SuccessMessages.DATA_LOADED_SUCCESSFULLY
                            )
                    }

                    Status.ERROR -> {
                        _adsState.value = _adsState.value?.copy(
                            data = null,
                            dataSet = null,
                            isLoading = false,
                            isFail = true,
                            isFailMessage = result.message,
                            isFailReason = Exception(result.message),
                            isSuccess = false,
                            isSuccessMessage = null
                        )
                    }
                    Status.LOADING -> {
                        _adsState.value = _adsState.value?.copy(
                            data = null,
                            dataSet = null,
                            isLoading = true,
                            isFail = false,
                            isFailMessage = null,
                            isFailReason = null,
                            isSuccess = false,
                            isSuccessMessage = null
                        )
                    }
                }
            }
        }
    }
}