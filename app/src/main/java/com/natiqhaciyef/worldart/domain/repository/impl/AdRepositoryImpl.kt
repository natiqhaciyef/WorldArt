package com.natiqhaciyef.worldart.domain.repository.impl

import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.source.AdSource
import com.natiqhaciyef.worldart.domain.mapper.toUIModel
import com.natiqhaciyef.worldart.domain.model.UIResult
import com.natiqhaciyef.worldart.domain.repository.AdRepository

class AdRepositoryImpl(
    private val ds: AdSource
): AdRepository {

    override suspend fun getAllAds(): List<UIResult<AdsModel>>? {
        return ds.getAllAds().adsResult?.map { it.toUIModel() }
    }
}