package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.model.io.AdsNetworkModel
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel
import com.natiqhaciyef.worldart.data.network.result.CRUDResponse
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

interface ArchitectureRepository: BaseRepository {

    suspend fun getAllArchitectures(): List<UIResult<ArchitectureModel>>?

    suspend fun insertArchitecture(architectureNetworkModel: ArchitectureNetworkModel): CRUDResponse

}