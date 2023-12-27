package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.data.model.PaintingModel
import com.natiqhaciyef.worldart.data.model.io.PaintingNetworkModel
import com.natiqhaciyef.worldart.domain.model.UIResult

fun UIResult<PaintingModel>.toNetworkModel(): PaintingNetworkModel {
    val history = Gson().toJson(this.data)
    return PaintingNetworkModel(
        id = this.id,
        painting = history,
        publishDate = this.publishDate
    )
}

fun PaintingNetworkModel.toUIModel(): UIResult<PaintingModel> {
    val painting = Gson().fromJson(this.painting, PaintingModel::class.java)
    return UIResult(
        id = this.id,
        data = painting,
        publishDate = this.publishDate
    )
}


