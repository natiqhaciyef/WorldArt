package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaintingModel(
    var title: String,
    var info: String?,
    var image: String,
    var painter: ArtistModel,
    var paintedYear: Int,
): Parcelable
