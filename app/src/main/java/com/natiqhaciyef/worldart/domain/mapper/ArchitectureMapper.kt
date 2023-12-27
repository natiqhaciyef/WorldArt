package com.natiqhaciyef.worldart.domain.mapper

import com.google.gson.Gson
import com.natiqhaciyef.worldart.data.model.ArchitectureModel
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel
import com.natiqhaciyef.worldart.domain.model.UIResult

fun ArchitectureNetworkModel.toUIModel(): UIResult<ArchitectureModel> {
    val architecture = Gson().fromJson(this.arch, ArchitectureModel::class.java)
    return UIResult<ArchitectureModel>(
        id = this.id,
        data = architecture,
        publishDate = this.publishDate
    )
}

fun UIResult<ArchitectureModel>.toNetworkModel(): ArchitectureNetworkModel {
    val architecture = Gson().toJson(this.data)
    return ArchitectureNetworkModel(
        id = this.id,
        arch = architecture,
        publishDate = this.publishDate
    )
}