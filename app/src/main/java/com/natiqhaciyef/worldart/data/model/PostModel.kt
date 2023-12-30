package com.natiqhaciyef.worldart.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostModel(
    var user: String,   // mapped user without password
    var description: String,
    var likedUsers: String, // list of liked users without password
    var image: String?,
): Parcelable
