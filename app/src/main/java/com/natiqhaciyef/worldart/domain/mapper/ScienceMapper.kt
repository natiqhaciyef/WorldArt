package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.data.model.ScienceModel
import com.natiqhaciyef.worldart.data.model.io.ScienceNetworkModel
import com.natiqhaciyef.worldart.domain.result.UIResult


fun UIResult<ScienceModel>.toNetworkModel(): ScienceNetworkModel {
    val science = Gson().toJson(this.data)
    return ScienceNetworkModel(
        id = this.id,
        science = science,
        publishDate = this.publishDate
    )
}

fun ScienceNetworkModel.toUIModel(): UIResult<ScienceModel> {
    val science = Gson().fromJson(this.science, ScienceModel::class.java)
    return UIResult(
        id = this.id,
        data = science,
        publishDate = this.publishDate
    )
}
