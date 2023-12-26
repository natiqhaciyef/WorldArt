package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScienceModel(
    var title: String,
    var field: String,
    var info: String,
    var scientist: String,
    var inventDate: String,
    var image: String?
) : Parcelable
