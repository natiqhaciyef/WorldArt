package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.config.EndPoints
import com.natiqhaciyef.worldart.data.network.result.AdsResult
import retrofit2.http.GET

interface AdsService {
    @GET(EndPoints.AdsEndpoint.GET)
    suspend fun getAllAds(): AdsResult
}