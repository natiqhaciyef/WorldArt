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
        onSuccess: (Boolean) -> Unit = {},
        onFail: (Exception?) -> Unit = {},
    ) {
        getAllUsersWithoutPasswordFirestoreUseCase.invoke(
            onSuccess = { list -> onSuccess.invoke(list.map { it.email }.contains(email)) },
            onFail = { exception -> onFail.invoke(exception) }
        )
    }
}