package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.io.AdsNetworkModel
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel
import com.natiqhaciyef.worldart.data.network.result.CRUDResponse
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

interface AdRepository: BaseRepository {

    suspend fun getAllAds(): List<UIResult<AdsModel>>?

    suspend fun insertAd(adsNetworkModel: AdsNetworkModel): CRUDResponse

    suspend fun deleteAd(id: Int): CRUDResponse
}