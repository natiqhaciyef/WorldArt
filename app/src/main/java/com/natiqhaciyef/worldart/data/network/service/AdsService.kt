package com.natiqhaciyef.worldart.data.network.service

import com.natiqhaciyef.worldart.data.network.result.AdsResult
import com.natiqhaciyef.worldart.data.network.result.CRUDResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import com.natiqhaciyef.worldart.data.network.config.EndPoints.AdsEndpoint

interface AdsService {

    @GET(AdsEndpoint.GET)
    suspend fun getAllAds(): AdsResult

    @POST(AdsEndpoint.INSERT)
    @FormUrlEncoded
    suspend fun insertAd(
        @Field("ad") ad: String,
        @Field("publish_date") publishDate: String,
    ): CRUDResponse
}