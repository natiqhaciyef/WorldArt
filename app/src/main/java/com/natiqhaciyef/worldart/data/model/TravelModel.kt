package com.natiqhaciyef.worldart.data.model

import com.google.gson.annotations.SerializedName

data class TravelModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("info")
    var info: String,
    @SerializedName("country")
    var country: String,
    @SerializedName("city")
    var city: String
)
