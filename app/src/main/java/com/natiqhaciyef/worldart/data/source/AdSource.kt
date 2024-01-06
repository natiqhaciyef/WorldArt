package com.natiqhaciyef.worldart.data.source

import com.natiqhaciyef.worldart.data.model.io.AdsNetworkModel
import com.natiqhaciyef.worldart.data.network.service.AdsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdSource(
    private val service: AdsService,
) {

    suspend fun getAllAds() = withContext(Dispatchers.IO) {
        service.getAllAds()
    }

    suspend fun insertAd(adsNetworkModel: AdsNetworkModel) = withContext(Dispatchers.IO) {
        service.insertAd(
            ad = adsNetworkModel.ad,
            publishDate = adsNetworkModel.publishDate
        )
    }
}