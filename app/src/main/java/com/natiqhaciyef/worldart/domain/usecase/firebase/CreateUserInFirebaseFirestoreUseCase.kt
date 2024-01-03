package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.FirebaseDirectories
import javax.inject.Inject

class CreateUserInFirebaseFirestoreUseCase @Inject constructor(
    repository: FirebaseRepository
) : BaseUseCase<FirebaseRepository>(repository) {

    operator fun invoke(
        username: String,
        email: String,
        password: String,
        onSuccess: () -> Unit = {},
        onFail: (Exception?) -> Unit = {}
    ) {
        val map = hashMapOf<String, Any?>()
        map["username"] = username
        map["email"] = email
        map["password"] = password

        repository.getFirestore()
            .collection(FirebaseDirectories.USER_DIRECTORY)
            .document(email)
            .set(map)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener(onFail)
    }
}