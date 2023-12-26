package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.config.BaseRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

interface ArchitectureRepository: BaseRepository {

    suspend fun getAllArchitectures(): List<UIResult<ArchitectureModel>>?
}