package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.source.ArchitectureSource
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.repository.ArchitectureRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

class ArchitectureRepositoryImpl(
    private val ds: ArchitectureSource
) : ArchitectureRepository {
    override suspend fun getAllArchitectures(): List<UIResult<ArchitectureModel>>? {
        return ds.getAllArchitecturesRemote().archResult?.map { it.toUIModel() }
    }
}