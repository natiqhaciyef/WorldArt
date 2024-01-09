package com.natiqhaciyef.worldart.ui.fragment.details.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.usecase.history.GetAllHistoryRemoteUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getAllHistoryRemoteUseCase: GetAllHistoryRemoteUseCase
) : BaseViewModel() {

    private val _state = MutableLiveData<BaseUIState<UIResult<HistoryModel>>>(BaseUIState())
    val state: LiveData<BaseUIState<UIResult<HistoryModel>>>
        get() = _state


    init {
        getAllHistoryRemote()
    }

    private fun getAllHistoryRemote() {
        viewModelScope.launch {
            getAllHistoryRemoteUseCase.invoke().collectLatest { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        if (!result.data.isNullOrEmpty())
                            _state.value = _state.value?.copy(
                                data = result.data[0],
                                dataSet = result.data,
                                isLoading = false,
                                isSuccess = true,
                                isSuccessMessage = SuccessMessages.DATA_LOADED_SUCCESSFULLY,
                                isFailReason = null,
                                isFailMessage = null,
                                isFail = false
                            )
                    }

                    Status.ERROR -> {
                        _state.value = _state.value?.copy(
                            data = null,
                            dataSet = listOf(),
                            isLoading = false,
                            isSuccess = false,
                            isSuccessMessage = null,
                            isFail = true,
                            isFailMessage = result.message,
                            isFailReason = Exception(result.message)
                        )
                    }

                    Status.LOADING -> {
                        _state.value = _state.value?.copy(
                            data = null,
                            dataSet = listOf(),
                            isLoading = true,
                            isSuccess = false,
                            isSuccessMessage = null,
                            isFail = false,
                            isFailMessage = null,
                            isFailReason = null
                        )
                    }
                }
            }
        }
    }
}