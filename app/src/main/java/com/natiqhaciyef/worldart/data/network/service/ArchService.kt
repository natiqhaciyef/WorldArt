package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.config.EndPoints.ArchitectureEndpoint
import com.natiqhaciyef.worldart.data.network.result.ArchResult
import com.natiqhaciyef.worldart.data.network.result.CRUDResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ArchService {

    @GET(ArchitectureEndpoint.GET)
    suspend fun getAllArchitectures(): ArchResult

    @POST(ArchitectureEndpoint.INSERT)
    @FormUrlEncoded
    suspend fun insertArchitecture(
        @Field("architecture") arch: String,
        @Field("publish_date") publishDate: String,
    ): CRUDResponse
}