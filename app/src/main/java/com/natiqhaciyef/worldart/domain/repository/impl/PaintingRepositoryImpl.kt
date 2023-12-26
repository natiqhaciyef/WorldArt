package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.PaintingModel
import com.natiqhaciyef.worldart.data.source.PaintingSource
import com.natiqhaciyef.worldart.domain.mapper.toNetworkModel
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.repository.PaintingRepository
import com.natiqhaciyef.worldart.domain.result.UIResult

class PaintingRepositoryImpl(
    private val ds: PaintingSource
): PaintingRepository {
    override suspend fun getAllPaintings(): List<UIResult<PaintingModel>>? {
        return ds.getAllPaintings().archResult?.map { it.toUIModel() }
    }
}