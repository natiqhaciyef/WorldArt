package com.natiqhaciyef.worldart.domain.usecase.arch

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import com.natiqhaciyef.worldart.domain.usecase.config.BaseUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllArchitectureRemoteUseCase @Inject constructor(
    private val repository: ArchitectureRepository
) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = repository.getAllArchitectures()
        if (result != null) {
            emit(Resource.success(result))
        } else {
            emit(Resource.error(BaseUseCase.LOADING_FAIL, null))
        }
    }
}