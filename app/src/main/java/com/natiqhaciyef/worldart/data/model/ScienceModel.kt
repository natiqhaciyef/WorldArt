package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScienceModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("field")
    var field: String,
    @SerializedName("info")
    var info: String,
    @SerializedName("scientist")
    var scientist: String,
    @SerializedName("invent_date")
    var inventDate: String,
    @SerializedName("image")
    var image: String?
) : Parcelable
