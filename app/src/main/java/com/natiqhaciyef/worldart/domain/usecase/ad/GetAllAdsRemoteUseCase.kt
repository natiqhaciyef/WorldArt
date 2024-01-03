package com.natiqhaciyef.worldart.domain.usecase.ad

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.common.objects.ErrorMessages
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import com.natiqhaciyef.worldart.domain.repository.AdRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllAdsRemoteUseCase @Inject constructor(
    repository: AdRepository,
) : BaseUseCase<AdRepository>(repository) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = repository.getAllAds()
        if (result != null) {
            emit(Resource.success(result))
        } else {
            emit(Resource.error(ConfigUseCase.LOADING_FAIL, null))
        }
    }
}