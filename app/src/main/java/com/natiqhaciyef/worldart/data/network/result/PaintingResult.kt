package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.PaintingNetworkModel

data class PaintingResult(
    @SerializedName("painting_table")
    val archResult: List<PaintingNetworkModel>?
)
