package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.config.EndPoints
import com.natiqhaciyef.worldart.data.network.result.TravelResult
import retrofit2.http.GET

interface TravelService {

    @GET(EndPoints.TravelEndpoint.GET)
    suspend fun getAllTravels(): TravelResult
}