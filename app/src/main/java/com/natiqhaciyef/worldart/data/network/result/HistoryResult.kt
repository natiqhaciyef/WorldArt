package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.HistoryNetworkModel

data class HistoryResult(
    @SerializedName("history_table")
    val archResult: List<HistoryNetworkModel>?
)
