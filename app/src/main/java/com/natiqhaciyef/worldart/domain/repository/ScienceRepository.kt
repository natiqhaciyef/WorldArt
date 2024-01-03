package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.ScienceModel
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

interface ScienceRepository: BaseRepository {

    suspend fun getAllSciences(): List<UIResult<ScienceModel>>?
}