package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.ScienceModel
import com.natiqhaciyef.worldart.data.source.ScienceSource
import com.natiqhaciyef.worldart.domain.mapper.toNetworkModel
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.repository.ScienceRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

class ScienceRepositoryImpl(
    private val ds: ScienceSource
): ScienceRepository {
    override suspend fun getAllSciences(): List<UIResult<ScienceModel>>? {
        return ds.getAllSciences().archResult?.map { it.toUIModel() }
    }
}