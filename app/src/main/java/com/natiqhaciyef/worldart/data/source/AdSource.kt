package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.network.service.AdsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdSource(
    private val service: AdsService,
) {

    suspend fun getAllAds() = withContext(Dispatchers.IO) {
        service.getAllAds()
    }
}