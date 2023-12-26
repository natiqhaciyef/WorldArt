package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.data.model.HistoryModel
import com.natiqhaciyef.worldart.data.model.io.HistoryNetworkModel
import com.natiqhaciyef.worldart.domain.result.UIResult


fun HistoryNetworkModel.toUIModel(): UIResult<HistoryModel> {
    val history = Gson().fromJson(this.history, HistoryModel::class.java)
    return UIResult(
        id = this.id,
        data = history,
        publishDate = this.publishDate
    )
}


fun UIResult<HistoryModel>.toNetworkModel(): HistoryNetworkModel {
    val history = Gson().toJson(this.data)
    return HistoryNetworkModel(
        id = this.id,
        history = history,
        publishDate = this.publishDate
    )
}
