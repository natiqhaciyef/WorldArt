package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.EndPoints
import com.natiqhaciyef.worldart.data.network.result.PaintingResult
import retrofit2.http.GET

interface PaintingService {

    @GET(EndPoints.PaintingEndpoint.GET)
    suspend fun getAllPaintings(): PaintingResult
}