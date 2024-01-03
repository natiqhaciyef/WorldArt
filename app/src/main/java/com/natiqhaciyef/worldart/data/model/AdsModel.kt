package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AdsModel(
    var title: String,
    var image: String,
    var description: String,
    var date: String,
    var deadline: String,
    var category: String,
): Parcelable
