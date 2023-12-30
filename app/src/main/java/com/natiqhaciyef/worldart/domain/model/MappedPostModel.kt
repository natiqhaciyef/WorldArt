package com.natiqhaciyef.worldart.domain.model

import android.os.Parcelable
import com.natiqhaciyef.worldart.data.model.UserModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class MappedPostModel(
    var user: MappedUserWithoutPassword,
    var description: String,
    var likedUsers: List<MappedUserWithoutPassword>,
    var image: String?,
) : Parcelable
