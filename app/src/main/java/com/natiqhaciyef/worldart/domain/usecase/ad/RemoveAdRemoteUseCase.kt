package com.natiqhaciyef.worldart.domain.usecase.ad

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import com.natiqhaciyef.worldart.domain.repository.AdRepository
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoveAdRemoteUseCase @Inject constructor(
    repository: AdRepository
) : BaseUseCase<AdRepository>(repository) {

    suspend operator fun invoke(id: Int) = flow {
        emit(Resource.loading(null))

        val result = repository.deleteAd(id)
        if (result.success > 0) {
            emit(Resource.success(result.message))
        } else {
            emit(Resource.error(ConfigUseCase.REMOVE_FAIL, result.message))
        }
    }

}