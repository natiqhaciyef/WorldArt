package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.config.EndPoints
import com.natiqhaciyef.worldart.data.network.result.PostResult
import retrofit2.http.GET

interface PostService {

    @GET(EndPoints.PostEndpoint.GET)
    suspend fun getAllPosts(): PostResult
}