package com.natiqhaciyef.worldart.domain.usecase.science

import com.natiqhaciyef.worldart.common.classes.Resource
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.repository.ScienceRepository
import com.natiqhaciyef.worldart.domain.base.ConfigUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllScienceRemoteUseCase @Inject constructor(
    repository: ScienceRepository
): BaseUseCase<ScienceRepository>(repository) {

    suspend operator fun invoke() = flow {
        emit(Resource.loading(null))

        val result = super.repository.getAllSciences()
        if (result != null){
            emit(Resource.success(result))
        }else{
            emit(Resource.error(ConfigUseCase.LOADING_FAIL, null))
        }
    }
}