package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArchitectureModel(
    var id: Int,
    var title: String,
    var image: String,
    var info: String,
    var category: String,
    var history: String?,
    var architect: ArtistModel?,
    var place: PlaceModel?,
    var publishDate: String
) : Parcelable
