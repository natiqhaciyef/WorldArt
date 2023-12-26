package com.natiqhaciyef.worldart.data.model.io

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.network.BaseNetworkResult

data class ArchitectureNetworkModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("architecture")
    var arch: String,
    @SerializedName("publish_date")
    var publishDate: String
): BaseNetworkResult
