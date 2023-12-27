package com.natiqhaciyef.worldart.domain.mapper

import com.natiqhaciyef.worldart.common.helpers.hashPassword
import com.natiqhaciyef.worldart.common.helpers.toSQLiteList
import com.natiqhaciyef.worldart.common.helpers.toSQLiteString
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.model.MappedUserHashedPassword

fun UserModel.toMapped(): MappedUserHashedPassword {
    return MappedUserHashedPassword(
        name = this.name,
        email = this.email,
        hashedPassword = listOf(hashPassword(this.password), this.password).toSQLiteString()
    )
}

fun MappedUserHashedPassword.toStandard(): UserModel? {
    val hashPassword = this.hashedPassword.toSQLiteList().first()
    val password = this.hashedPassword.toSQLiteList().last()
    return if (hashPassword == hashPassword(password))
        UserModel(
            name = this.name,
            email = this.email,
            password = password
        )
    else
        null
}