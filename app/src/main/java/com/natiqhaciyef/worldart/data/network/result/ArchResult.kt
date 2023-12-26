package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.ArchitectureNetworkModel

data class ArchResult(
    @SerializedName("arch_table")
    val archResult: List<ArchitectureNetworkModel>?
)
