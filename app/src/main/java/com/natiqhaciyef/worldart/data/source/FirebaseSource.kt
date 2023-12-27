package com.natiqhaciyef.worldart.data.source

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseSource(
    val auth: FirebaseAuth,
    val firestore: FirebaseFirestore
)
