package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ScienceModel
import com.natiqhaciyef.worldart.domain.result.UIResult

interface ScienceRepository {
    suspend fun getAllSciences(): List<UIResult<ScienceModel>>?
}