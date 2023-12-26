package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.TravelNetworkModel

data class TravelResult(
    @SerializedName("travel_table")
    val archResult: List<TravelNetworkModel>?
)
