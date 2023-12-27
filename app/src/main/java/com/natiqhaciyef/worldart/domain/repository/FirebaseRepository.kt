package com.natiqhaciyef.worldart.domain.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

interface FirebaseRepository : BaseRepository {
    fun getAuth(): FirebaseAuth

    fun getFirestore(): FirebaseFirestore

}