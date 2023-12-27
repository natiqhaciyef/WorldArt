package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.config.EndPoints.ArchitectureEndpoint
import com.natiqhaciyef.worldart.data.network.result.ArchResult
import retrofit2.http.GET

interface ArchService {

    @GET(ArchitectureEndpoint.GET)
    suspend fun getAllArchitectures(): ArchResult
}