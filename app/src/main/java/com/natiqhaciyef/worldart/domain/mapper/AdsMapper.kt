package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.data.model.AdsModel
import com.natiqhaciyef.worldart.data.model.io.AdsNetworkModel
import com.natiqhaciyef.worldart.domain.model.UIResult

fun AdsNetworkModel.toUIModel(): UIResult<AdsModel> {
    val ads = Gson().fromJson(this.ads, AdsModel::class.java)
    return UIResult(
        id = this.id,
        data = ads,
        publishDate = this.publishDate
    )
}

fun UIResult<AdsModel>.toNetworkModel(): AdsNetworkModel {
    val ads = Gson().toJson(this.data)
    return AdsNetworkModel(
        id = this.id,
        ads = ads,
        publishDate = this.publishDate
    )
}