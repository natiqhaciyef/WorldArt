package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.TravelModel
import com.natiqhaciyef.worldart.data.source.TravelSource
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.repository.TravelRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

class TravelRepositoryImpl(
    private val ds: TravelSource
) : TravelRepository {
    override suspend fun getAllTravels(): List<UIResult<TravelModel>>? {
        return ds.getAllTravels().archResult?.map { it.toUIModel() }
    }
}