package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.AdsNetworkModel
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel

data class AdsResult(
    @SerializedName("ads_table")
    val adsResult: List<AdsNetworkModel>?
)
