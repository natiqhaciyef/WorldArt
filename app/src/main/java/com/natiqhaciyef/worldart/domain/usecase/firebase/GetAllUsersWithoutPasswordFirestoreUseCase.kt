package com.natiqhaciyef.worldart.domain.usecase.firebase

import com.natiqhaciyef.worldart.common.helpers.toUserModel
import com.natiqhaciyef.worldart.domain.model.MappedUserWithoutPassword
import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository
import com.natiqhaciyef.worldart.domain.base.BaseUseCase
import com.natiqhaciyef.worldart.domain.base.FirebaseDirectories
import javax.inject.Inject

class GetAllUsersWithoutPasswordFirestoreUseCase @Inject constructor(
    repository: FirebaseRepository
) : BaseUseCase<FirebaseRepository>(repository) {

    operator fun invoke(
        onSuccess: (MutableList<MappedUserWithoutPassword>) -> Unit = {},
        onFail: (Exception?) -> Unit = {},
    ) {
        val userList = mutableListOf<MappedUserWithoutPassword>()

        super.repository.getFirestore()
            .collection(FirebaseDirectories.USER_DIRECTORY)
            .addSnapshotListener { value, error ->
                if (value != null && !value.isEmpty) {
                    val docs = value.documents
                    for (doc in docs) {
                        val user = doc.toUserModel()
                        userList.add(user)
                    }

                    onSuccess(userList)
                } else {
                    onFail(error)
                }
            }
    }
}