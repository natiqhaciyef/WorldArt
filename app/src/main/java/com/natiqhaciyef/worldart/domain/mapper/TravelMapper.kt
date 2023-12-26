package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.data.model.TravelModel
import com.natiqhaciyef.worldart.data.model.io.TravelNetworkModel
import com.natiqhaciyef.worldart.domain.result.UIResult


fun UIResult<TravelModel>.toNetworkModel(): TravelNetworkModel {
    val data = Gson().toJson(this.data)
    return TravelNetworkModel(
        id = this.id,
        travel = data,
        publishDate = this.publishDate
    )
}

fun TravelNetworkModel.toUIModel(): UIResult<TravelModel> {
    val data = Gson().fromJson(this.travel, TravelModel::class.java)
    return UIResult(
        id = this.id,
        data = data,
        publishDate = this.publishDate
    )
}