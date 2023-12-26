package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.PaintingModel
import com.natiqhaciyef.worldart.domain.result.UIResult

interface PaintingRepository {
    suspend fun getAllPaintings(): List<UIResult<PaintingModel>>?
}