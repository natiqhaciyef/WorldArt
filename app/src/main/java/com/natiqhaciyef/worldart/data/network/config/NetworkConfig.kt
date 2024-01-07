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
        const val INSERT = "architecture/insert_arch.php$apiResult"
        const val UPDATE = "architecture/update_arch.php$apiResult"
        const val DELETE = "architecture/delete_arch.php$apiResult"
    }

    data object HistoryEndpoint : EndPoints() {
        const val GET = "history/get_histories.php$apiResult"
    }

    data object PaintingEndpoint : EndPoints() {
        const val GET = "painting/get_paintings.php$apiResult"
    }

    data object ScienceEndpoint : EndPoints() {
        const val GET = "science/get_sciences.php$apiResult"
    }

    data object TravelEndpoint : EndPoints() {
        const val GET = "travel/get_travels.php$apiResult"
    }

    data object PostEndpoint : EndPoints() {
        const val GET = "post/get_posts.php$apiResult"
    }

    data object AdsEndpoint : EndPoints() {
        const val GET = "ad/get_ads.php$apiResult"
        const val INSERT = "ad/insert_ad.php$apiResult"
        const val DELETE = "ad/delete_ad.php$apiResult"
    }
}
