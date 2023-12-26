package com.natiqhaciyef.worldart.domain.usecase.travel


import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.config.BaseUseCase
import com.natiqhaciyef.worldart.domain.repository.TravelRepository
import com.natiqhaciyef.worldart.domain.config.ConfigUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTravelRemoteUseCase @Inject constructor(
    repository: TravelRepository
) : BaseUseCase<TravelRepository>(repository) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = super.repository.getAllTravels()
        if (result != null) {
            emit(Resource.success(result))
        } else {
            emit(Resource.error(ConfigUseCase.LOADING_FAIL, null))
        }
    }
}