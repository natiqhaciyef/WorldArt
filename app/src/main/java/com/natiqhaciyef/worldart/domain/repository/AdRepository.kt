package com.natiqhaciyef.worldart.domain.repository

import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.domain.base.BaseRepository
import com.natiqhaciyef.worldart.domain.model.UIResult

interface AdRepository: BaseRepository {

    suspend fun getAllAds(): List<UIResult<AdsModel>>?
}