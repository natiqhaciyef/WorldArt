package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.network.service.PaintingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PaintingSource(
    private val service: PaintingService
) {

    suspend fun getAllPaintings() = withContext(Dispatchers.IO) {
        service.getAllPaintings()
    }
}