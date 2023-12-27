package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelModel(
    var title: String,
    var info: String,
    var country: String,
    var city: String
): Parcelable
