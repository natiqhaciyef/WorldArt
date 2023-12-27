package com.natiqhaciyef.worldart.data.network.config

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object NetworkConfig {
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val logger = OkHttpClient.Builder().addInterceptor(interceptor)

    const val API_KEY = "30e171ab-3e37-4a9e-b146-5965922caf97"
    const val BASE_URL = "https://techtive.tech/worldart/"
}

sealed class EndPoints {
    companion object{
        protected const val apiResult = "?apiKey=${NetworkConfig.API_KEY}"
    }

    data object ArchitectureEndpoint : EndPoints() {
        const val GET = "architecture/get_archs.php$apiResult"
    }

    data object HistoryEndpoint : EndPoints() {
        const val GET = "history/get_histories.php$apiResult"
    }

    data object PaintingEndpoint : EndPoints() {
        const val GET = "painting/get_paintings.php$$apiResult"
    }

    data object ScienceEndpoint : EndPoints() {
        const val GET = "science/get_sciences.php$$apiResult"
    }

    data object TravelEndpoint : EndPoints() {
        const val GET = "travel/get_travels.php$$apiResult"
    }
}
