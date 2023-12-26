package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.EndPoints
import com.natiqhaciyef.worldart.data.network.result.ScienceResult
import retrofit2.http.GET

interface ScienceService {

    @GET(EndPoints.ScienceEndpoint.GET)
    suspend fun getAllSciences(): ScienceResult
}