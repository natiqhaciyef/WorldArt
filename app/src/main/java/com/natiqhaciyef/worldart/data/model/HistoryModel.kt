package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryModel(
    var title: String,
    var details: String,
    var belongs: String,
    var image: String
) : Parcelable
