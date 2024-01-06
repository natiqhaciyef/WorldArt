package com.natiqhaciyef.worldart.domain.usecase.ad

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import com.natiqhaciyef.worldart.domain.mapper.toNetworkModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.repository.AdRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertAdRemoteUseCase @Inject constructor(
    repository: AdRepository,
) : BaseUseCase<AdRepository>(repository) {

    suspend operator fun invoke(adUIModel: UIResult<AdsModel>) = flow {
        emit(Resource.loading(null))

        val networkModel = adUIModel.toNetworkModel()
        val result = super.repository.insertAd(networkModel)
        println(result)
        if (result.success > 0) {
            emit(Resource.success(ConfigUseCase.INSERT_SUCCESS))
        } else {
            emit(Resource.error(ConfigUseCase.INSERT_FAIL, null))
        }
    }

}