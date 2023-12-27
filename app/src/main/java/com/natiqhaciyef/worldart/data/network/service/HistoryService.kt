package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.config.EndPoints
import com.natiqhaciyef.worldart.data.network.result.HistoryResult
import retrofit2.http.GET


interface HistoryService {

    @GET(EndPoints.HistoryEndpoint.GET)
    suspend fun getAllHistories(): HistoryResult
}