package com.natiqhaciyef.worldart.data.model.io

import com.google.gson.annotations.SerializedName

data class PostNetworkModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("post")
    var post: String,
    @SerializedName("publish_date")
    var publishDate: String
)