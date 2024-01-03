package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import javax.inject.Inject

class ResetPasswordBySendingWebLinkFirebaseUseCase @Inject constructor(
    repository: FirebaseRepository
) : BaseUseCase<FirebaseRepository>(repository) {

    suspend operator fun invoke(
        email: String,
        onSuccess: () -> Unit = {},
        onFail: (Exception?) -> Unit = {}
    ) {
        repository.getAuth()
            .sendPasswordResetEmail(email)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener(onFail)
    }
}