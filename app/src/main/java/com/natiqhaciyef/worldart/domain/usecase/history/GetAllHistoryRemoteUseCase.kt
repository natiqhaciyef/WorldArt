package com.natiqhaciyef.worldart.domain.usecase.history

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.config.BaseUseCase
import com.natiqhaciyef.worldart.domain.repository.HistoryRepository
import com.natiqhaciyef.worldart.domain.config.ConfigUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllHistoryRemoteUseCase @Inject constructor(
    repository: HistoryRepository
): BaseUseCase<HistoryRepository>(repository) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = super.repository.getAllHistories()
        if (result != null){
            emit(Resource.success(result))
        }else{
            emit(Resource.error(ConfigUseCase.LOADING_FAIL, null))
        }
    }
}