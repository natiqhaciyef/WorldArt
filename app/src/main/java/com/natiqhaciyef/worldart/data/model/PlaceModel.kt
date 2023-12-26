package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaceModel(
    var id: Int,
    var city: String,
    var country: String,
    var image: String?,
    var flag: String?,
    var capital: String,
    var info: String?
) : Parcelable
