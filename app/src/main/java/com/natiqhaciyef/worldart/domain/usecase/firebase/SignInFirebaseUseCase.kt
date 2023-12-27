package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.usecase.BaseUseCase
import javax.inject.Inject

class SignInFirebaseUseCase @Inject constructor(
    repository: FirebaseRepository
) : BaseUseCase<FirebaseRepository>(repository) {

    suspend operator fun invoke(
        email: String,
        password: String,
        onSuccess: () -> Unit = {},
        onFail: (Exception?) -> Unit = {}
    ) {
        super.repository.getAuth()
            .signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener(onFail)
    }
}