package com.natiqhaciyef.worldart.domain.usecase.arch

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoveArchRemoteUseCase @Inject constructor(
    repository: ArchitectureRepository
): BaseUseCase<ArchitectureRepository>(repository) {

    suspend operator fun invoke(id: Int) = flow{
        emit(Resource.loading(null))

        val result = super.repository.deleteArchitecture(id)
        if (result.success > 0){
            emit(Resource.success(ConfigUseCase.REMOVE_SUCCESS))
        }else{
            emit(Resource.error(ConfigUseCase.REMOVE_FAIL, result.message))
        }
    }

}