package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.google.firebase.auth.FirebaseAuth
import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.usecase.BaseUseCase
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    repository: FirebaseRepository
) : BaseUseCase<FirebaseRepository>(repository) {

    operator fun invoke() {
        super.repository.getAuth().signOut()
    }
}