package com.natiqhaciyef.worldart.data.model.io

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.network.BaseNetworkResult


data class PaintingNetworkModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("painting")
    var painting: String,
    @SerializedName("publish_date")
    var publishDate: String
): BaseNetworkResult
