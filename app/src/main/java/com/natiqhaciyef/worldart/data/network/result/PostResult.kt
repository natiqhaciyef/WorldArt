package com.natiqhaciyef.worldart.data.network.result

import com.google.gson.annotations.SerializedName
import com.natiqhaciyef.worldart.data.model.io.PostNetworkModel

data class PostResult(
    @SerializedName("post_table")
    var postResult: List<PostNetworkModel>?
)
