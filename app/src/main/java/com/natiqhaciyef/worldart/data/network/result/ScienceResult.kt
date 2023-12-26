package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.ScienceNetworkModel

data class ScienceResult(
    @SerializedName("science_table")
    val archResult: List<ScienceNetworkModel>?
)
