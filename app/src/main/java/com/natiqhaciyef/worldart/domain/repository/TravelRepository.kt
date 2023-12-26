package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.TravelModel
import com.natiqhaciyef.worldart.domain.config.BaseRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

interface TravelRepository: BaseRepository {

    suspend fun getAllTravels(): List<UIResult<TravelModel>>?
}