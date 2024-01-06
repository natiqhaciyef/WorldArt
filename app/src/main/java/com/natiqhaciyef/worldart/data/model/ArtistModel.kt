package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistModel(
    var id: Int,
    var fullname: String,
    var birthYear: String?,
    var birthPlace: String?,
    var deadYear: String?,
    var deadPlace: String?,
    var image: String?,
    var age: Int?,
    var info: String?,
    var fields: String
): Parcelable
