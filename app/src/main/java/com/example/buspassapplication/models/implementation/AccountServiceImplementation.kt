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
import javax.inject.Inject

class AccountServiceImplementation @Inject constructor() : AccountService {
    override val currentUser: Flow<User?>
        get() = callbackFlow {
            val listener =
                FirebaseAuth.AuthStateListener { auth ->
                    val firebaseUser = auth.currentUser
                    if (firebaseUser != null) {
                        FirebaseFirestore
                            .getInstance()
                            .collection("users")
                            .document(firebaseUser.uid)
                            .get()
                            .addOnSuccessListener { document ->
                                val user = document?.let {
                                    User(
                                        id = it.getString("uid"),
                                        surname = it.getString("surname"),
                                        lastname = it.getString("lastname"),
                                        dateOfBirth = it.getString("dateOfBirth"),
                                        gender = it.getString("gender"),
                                        email = firebaseUser.email,
                                        guardian = it.getString("guardian"),
                                        phone = it.getString("phone"),
                                        aadhar = it.getString("aadhar"),
                                        houseNumber = it.getString("houseNumber"),
                                        street = it.getString("street"),
                                        area = it.getString("area"),
                                        district = it.getString("district"),
                                        city = it.getString("city"),
                                        state = it.getString("state"),
                                        pincode = it.getString("pincode")
                                    )
                                }
                                trySend(user)
                            }
                            .addOnFailureListener {
                                trySend(null)
                            }
                    }
                }
            Firebase.auth.addAuthStateListener(listener)
            awaitClose { Firebase.auth.removeAuthStateListener(listener) }
        }

    override val currentUserId: String
        get() = Firebase.auth.currentUser?.uid.orEmpty()

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override suspend fun signUp(
        email: String,
        password: String,
        surname: String,
        lastname: String
    ) {
        val taskResult = Firebase.auth.createUserWithEmailAndPassword(email, password).await()

        val userId = taskResult.user?.uid
            ?: throw IllegalStateException("User Id is Null, i.e no user has been created by given email and password")

        val userDetails = hashMapOf(
            "uid" to userId,
            "surname" to surname,
            "lastname" to lastname,
            "email" to "",
            "phone" to "",
            "dateOfBirth" to "",
            "aadhar" to "",
            "houseNumber" to "",
            "street" to "",
            "area" to "",
            "district" to "",
            "city" to "",
            "state" to "",
            "pincode" to ""
        )

        val fireStoreResult =
            FirebaseFirestore.getInstance().collection("users").document(userId).set(userDetails)
                .await()
    }

    override suspend fun signIn(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun updateUser(user: User) {
        FirebaseFirestore.getInstance().collection("users").document()
    }

    override suspend fun signOut() {
        Firebase.auth.signOut()
    }

    override suspend fun deleteAccount() {
        Firebase.auth.currentUser!!.delete().await()
    }
}