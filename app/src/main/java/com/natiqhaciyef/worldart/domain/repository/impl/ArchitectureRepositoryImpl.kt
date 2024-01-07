package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel
import com.natiqhaciyef.worldart.data.network.result.CRUDResponse
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

    override suspend fun insertArchitecture(architectureNetworkModel: ArchitectureNetworkModel): CRUDResponse {
        return ds.insertArchitecturesRemote(architectureNetworkModel)
    }

    override suspend fun updateArchitecture(architectureNetworkModel: ArchitectureNetworkModel): CRUDResponse {
        return ds.updateArchitecturesRemote(architectureNetworkModel)
    }

    override suspend fun deleteArchitecture(id: Int): CRUDResponse {
        return ds.deleteArchitecturesRemote(id)
    }
}