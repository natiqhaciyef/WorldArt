package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistModel(
    var id: Int,
    var fullname: String,
    var birth: String,
    var image: String?,
    var dead: String,
    var age: Int,
    var info: String,
    var fields: String
): Parcelable
