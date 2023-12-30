package com.natiqhaciyef.worldart.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MappedUserWithoutPassword(
    val name: String,
    val email: String
) : Parcelable
