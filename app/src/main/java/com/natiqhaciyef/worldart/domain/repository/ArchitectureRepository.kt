package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

interface ArchitectureRepository: BaseRepository {

    suspend fun getAllArchitectures(): List<UIResult<ArchitectureModel>>?
}