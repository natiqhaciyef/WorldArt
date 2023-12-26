package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ScienceModel
import com.natiqhaciyef.worldart.domain.config.BaseRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

interface ScienceRepository: BaseRepository {

    suspend fun getAllSciences(): List<UIResult<ScienceModel>>?
}