package com.natiqhaciyef.worldart.domain.repository.impl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.natiqhaciyef.worldart.data.source.FirebaseSource
import com.natiqhaciyef.worldart.domain.repository.FirebaseRepository

class FirebaseRepositoryImpl(
    private val ds: FirebaseSource
) : FirebaseRepository {
    override fun getAuth(): FirebaseAuth = ds.auth

    override fun getFirestore(): FirebaseFirestore = ds.firestore
}