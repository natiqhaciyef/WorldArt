package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.natiqhaciyef.worldart.domain.model.MappedUserWithoutPassword
import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.usecase.BaseUseCase
import javax.inject.Inject

class CheckUseByEmailFirestoreUseCase @Inject constructor(
    private val getAllUsersWithoutPasswordFirestoreUseCase: GetAllUsersWithoutPasswordFirestoreUseCase,
    repository: FirebaseRepository
) : BaseUseCase<FirebaseRepository>(repository) {

    operator fun invoke(
        email: String,
    ): Boolean {
        val list = mutableListOf<MappedUserWithoutPassword>()
        getAllUsersWithoutPasswordFirestoreUseCase.invoke(
            onSuccess = { iterator ->
                list.addAll(iterator)
            },
            onFail = { }
        )
        return list.map { it.email }.contains(email)
    }
}