package com.natiqhaciyef.worldart.domain.usecase.arch

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllArchitectureRemoteUseCase @Inject constructor(
    repository: ArchitectureRepository
) : BaseUseCase<ArchitectureRepository>(repository) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = super.repository.getAllArchitectures()
        if (result != null) {
            emit(Resource.success(result))
        } else {
            emit(Resource.error(ConfigUseCase.LOADING_FAIL, null))
        }
    }
}