package com.natiqhaciyef.worldart.domain.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.natiqhaciyef.worldart.domain.base.BaseRepository

interface FirebaseRepository : BaseRepository {
    fun getAuth(): FirebaseAuth

    fun getFirestore(): FirebaseFirestore

}