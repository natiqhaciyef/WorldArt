package com.natiqhaciyef.worldart.domain.usecase.arch

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import com.natiqhaciyef.worldart.domain.mapper.toNetworkModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateArchRemoteUseCase @Inject constructor(
    repository: ArchitectureRepository
): BaseUseCase<ArchitectureRepository>(repository) {

    suspend operator fun invoke(archUIResult: UIResult<ArchitectureModel>) = flow{
        emit(Resource.loading(null))

        val networkModel = archUIResult.toNetworkModel()
        val result = repository.updateArchitecture(networkModel)

        if (result.success > 0){
            emit(Resource.success(ConfigUseCase.UPDATE_SUCCESS))
        }else{
            emit(Resource.error(ConfigUseCase.UPDATE_FAIL, result.message))
        }
    }

}