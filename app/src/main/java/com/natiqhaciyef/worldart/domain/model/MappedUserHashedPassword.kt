package com.natiqhaciyef.worldart.domain.model

data class MappedUserHashedPassword(
    val name: String,
    val email: String,
    val hashedPassword: String
)