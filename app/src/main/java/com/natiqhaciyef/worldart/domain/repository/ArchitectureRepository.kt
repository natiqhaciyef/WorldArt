package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.domain.result.UIResult

interface ArchitectureRepository {

    suspend fun getAllArchitectures(): List<UIResult<ArchitectureModel>>?
}