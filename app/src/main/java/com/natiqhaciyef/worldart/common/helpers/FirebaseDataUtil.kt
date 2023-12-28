package com.natiqhaciyef.worldart.common.helpers

import com.google.firebase.firestore.DocumentSnapshot
import com.natiqhaciyef.worldart.data.model.UserModel
import com.natiqhaciyef.worldart.domain.model.MappedUserWithoutPassword

fun DocumentSnapshot.toUserModel(): MappedUserWithoutPassword {
    return MappedUserWithoutPassword(
        name = this["name"].toString(),
        email = this["email"].toString()
    )
}

fun UserModel.toFirebaseHashMap(): HashMap<String, Any?> {
    val userMap = hashMapOf<String, Any?>()
    userMap["name"] = this.name
    userMap["email"] = this.email
    userMap["password"] = this.password

    return userMap
}