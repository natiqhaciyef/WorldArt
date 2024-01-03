package com.natiqhaciyef.worldart.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.natiqhaciyef.worldart.common.classes.Status
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.common.objects.SuccessMessages
import com.natiqhaciyef.worldart.common.objects.SuccessMessages.DATA_LOADED_SUCCESSFULLY
import com.natiqhaciyef.worldart.domain.model.MappedPostModel
import com.natiqhaciyef.worldart.domain.model.MappedUserWithoutPassword
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.usecase.firebase.GetAllUsersWithoutPasswordFirestoreUseCase
import com.natiqhaciyef.worldart.domain.usecase.post.GetAllPostsRemoteUseCase
import com.natiqhaciyef.worldart.ui.base.BaseUIState
import com.natiqhaciyef.worldart.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val getAllUsersWithoutPasswordFirestoreUseCase: GetAllUsersWithoutPasswordFirestoreUseCase,
    private val getAllPostsRemoteUseCase: GetAllPostsRemoteUseCase,
) : BaseViewModel() {
    private val _userState = MutableLiveData(BaseUIState<MappedUserWithoutPassword>())
    val userState: LiveData<BaseUIState<MappedUserWithoutPassword>>
        get() = _userState

    private val _postState = MutableLiveData(BaseUIState<UIResult<MappedPostModel>>())
    val postState: LiveData<BaseUIState<UIResult<MappedPostModel>>>
        get() = _postState

    init {
        getUserByEmail()
    }

    private fun getUserByEmail() {
        val email = auth.currentUser?.email

        getAllUsersWithoutPasswordFirestoreUseCase(
            onSuccess = {
                val users = it.filter { user -> user.email == email }
                println(users)
                if (users.isNotEmpty()) {
                    _userState.value = _userState.value?.copy(
                        data = users[0],
                        dataSet = null,
                        isLoading = false,
                        isFail = false,
                        isFailMessage = null,
                        isFailReason = null,
                        isSuccess = true,
                        isSuccessMessage = SuccessMessages.USER_FOUND_SUCCESS,
                    )
                }
            },
            onFail = {
                _userState.value = _userState.value?.copy(
                    data = null,
                    dataSet = null,
                    isLoading = false,
                    isFail = true,
                    isFailMessage = ErrorMessages.USER_NOT_FOUND,
                    isFailReason = it,
                    isSuccess = false,
                    isSuccessMessage = null,
                )
            }
        )
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            getAllPostsRemoteUseCase.invoke().collectLatest { result ->
                when (result.status) {
                    Status.LOADING -> {
                        _postState.value = _postState.value?.copy(
                            isLoading = true,
                            data = null,
                            dataSet = null,
                            isSuccessMessage = null,
                            isSuccess = false,
                            isFailReason = null,
                            isFailMessage = null,
                            isFail = false
                        )
                    }

                    Status.ERROR -> {
                        _postState.value = _postState.value?.copy(
                            isLoading = false,
                            data = null,
                            dataSet = null,
                            isSuccessMessage = null,
                            isSuccess = false,
                            isFailReason = Exception(result.message),
                            isFailMessage = result.message,
                            isFail = true
                        )
                    }

                    Status.SUCCESS -> {
                        if (result.data != null)
                            _postState.value = _postState.value?.copy(
                                isLoading = false,
                                data = if (result.data.isNotEmpty()) result.data.first() else null,
                                dataSet = result.data,
                                isSuccessMessage = DATA_LOADED_SUCCESSFULLY,
                                isSuccess = true,
                                isFailReason = null,
                                isFailMessage = null,
                                isFail = false
                            )
                    }

                }
            }
        }
    }
}