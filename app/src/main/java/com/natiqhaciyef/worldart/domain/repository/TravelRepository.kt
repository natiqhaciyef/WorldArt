package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.TravelModel
import com.natiqhaciyef.worldart.domain.model.UIResult

interface TravelRepository: BaseRepository {

    suspend fun getAllTravels(): List<UIResult<TravelModel>>?
}