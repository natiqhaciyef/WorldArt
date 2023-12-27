package com.natiqhaciyef.worldart.domain.usecase.painting

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.usecase.BaseUseCase
import com.natiqhaciyef.worldart.domain.repository.PaintingRepository
import com.natiqhaciyef.worldart.domain.usecase.ConfigUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPaintingRemoteUseCase @Inject constructor(
   repository: PaintingRepository
): BaseUseCase<PaintingRepository>(repository) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = super.repository.getAllPaintings()
        if (result != null){
            emit(Resource.success(result))
        }else{
            emit(Resource.error(ConfigUseCase.LOADING_FAIL, null))
        }
    }
}