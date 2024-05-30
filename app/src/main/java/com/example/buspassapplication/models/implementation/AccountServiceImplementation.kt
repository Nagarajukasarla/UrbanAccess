package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.service.AccountService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.lang.IllegalStateException
import javax.inject.Inject

class AccountServiceImplementation @Inject constructor() : AccountService {
    override val currentUser: Flow<User?>
        get() = callbackFlow {
            val listener =
                FirebaseAuth.AuthStateListener { auth ->
                    this.trySend(auth.currentUser?.let { User(it.uid) })
                }
            Firebase.auth.addAuthStateListener(listener)
            awaitClose { Firebase.auth.removeAuthStateListener(listener)}
        }

    override val currentUserId: String
        get() = Firebase.auth.currentUser?.uid.orEmpty()

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser !=  null
    }

    override suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ) {
        val taskResult = Firebase.auth.createUserWithEmailAndPassword(email, password).await()
        val userId = taskResult.user?.uid ?: throw IllegalStateException("User Id is Null, i.e no user has been created by given email and password")
        val userDetails = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName,
            "email" to email
        )
        FirebaseFirestore.getInstance().collection("users").document(userId).set(userDetails).await()
    }

    override suspend fun signIn(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun signOut() {
        Firebase.auth.signOut()
    }
    override suspend fun deleteAccount() {
        Firebase.auth.currentUser!!.delete().await()
    }
}