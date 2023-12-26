package com.natiqhaciyef.worldart.data.model.io

import com.google.gson.annotations.SerializedName

data class TravelNetworkModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("travel")
    var travel: String,
    @SerializedName("publish_date")
    var publishDate: String
)
