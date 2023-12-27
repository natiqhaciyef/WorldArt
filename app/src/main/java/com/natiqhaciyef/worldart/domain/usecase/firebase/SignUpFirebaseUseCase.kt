package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.usecase.BaseUseCase
import javax.inject.Inject

class SignUpFirebaseUseCase @Inject constructor(
    private val createUserInFirebaseFirestoreUseCase: CreateUserInFirebaseFirestoreUseCase,
    repository: FirebaseRepository,
) : BaseUseCase<FirebaseRepository>(repository) {

    suspend operator fun invoke(
        username: String,
        email: String,
        password: String,
        onSuccess: () -> Unit = {},
        onFail: (Exception?) -> Unit = {}
    ) {
        super.repository.getAuth()
            .createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                createUserInFirebaseFirestoreUseCase.invoke(
                    username = username,
                    email = email,
                    password = password,
                    onSuccess = onSuccess,
                    onFail = onFail
                )
            }.addOnFailureListener(onFail)
    }
}