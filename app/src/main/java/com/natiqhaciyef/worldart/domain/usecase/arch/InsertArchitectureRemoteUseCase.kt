package com.natiqhaciyef.worldart.domain.usecase.arch

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import com.natiqhaciyef.worldart.domain.mapper.toNetworkModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.repository.AdRepository
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertArchitectureRemoteUseCase @Inject constructor(
    repository: ArchitectureRepository,
) : BaseUseCase<ArchitectureRepository>(repository) {

    suspend operator fun invoke(archUIModel: UIResult<ArchitectureModel>) = flow {
        emit(Resource.loading(null))

        val networkModel = archUIModel.toNetworkModel()
        println(networkModel)
        val result = super.repository.insertArchitecture(networkModel)

        if (result.success > 0) {
            emit(Resource.success(ConfigUseCase.INSERT_SUCCESS))
        } else {
            emit(Resource.error(ConfigUseCase.INSERT_FAIL, result.message))
        }
    }

}