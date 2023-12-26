package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("details")
    var details: String,
    @SerializedName("belongs")
    var belongs: String,
) : Parcelable
