package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.data.Education
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.utils.OperationStatus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.resume

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
                                    val educationMap = it.get("education") as? Map<String, Any?>
                                    val education = educationMap?.let { map ->
                                        Education(
                                            studentId = map["studentId"] as? String,
                                            tenthBoard = map["tenthBoard"] as? String,
                                            yearOfPass = map["yearOfPass"] as? String,
                                            passType = map["passType"] as? String,
                                            tenthHallTicketId = map["tenthHallTicketId"] as? String,
                                            districtOfInstitute = map["districtOfInstitute"] as? String,
                                            mandalOfInstitute = map["mandalOfInstitute"] as? String,
                                            instituteAddress = map["instituteAddress"] as? String,
                                            instituteName = map["instituteName"] as? String,
                                            courseName = map["courseName"] as? String,
                                            admissionNumber = map["admissionNumber"] as? String
                                        )
                                    }

                                    User(
                                        id = it.getString("uid"),
                                        surname = it.getString("surname"),
                                        lastname = it.getString("lastname"),
                                        guardian = it.getString("guardian"),
                                        dateOfBirth = it.getString("dateOfBirth"),
                                        gender = it.getString("gender"),
                                        email = firebaseUser.email,
                                        phone = it.getString("phone"),
                                        aadhar = it.getString("aadhar"),
                                        houseNumber = it.getString("houseNumber"),
                                        street = it.getString("street"),
                                        area = it.getString("area"),
                                        district = it.getString("district"),
                                        city = it.getString("city"),
                                        state = it.getString("state"),
                                        pincode = it.getString("pincode"),
                                        education = education,
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
            "phone" to null,
            "dateOfBirth" to null,
            "aadhar" to null,
            "houseNumber" to null,
            "street" to null,
            "area" to null,
            "district" to null,
            "city" to null,
            "state" to null,
            "pincode" to null,
            "education" to null,
            "route" to null
        )

        FirebaseFirestore
            .getInstance()
            .collection("users")
            .document(userId)
            .set(userDetails)
            .await()
    }

    override suspend fun signIn(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun updateUser(userMap: Map<String, Any?>): OperationStatus {
        return suspendCancellableCoroutine { continuation ->
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document(currentUserId)
                .update(userMap)
                .addOnSuccessListener {
                    continuation.resume(OperationStatus.Success)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(OperationStatus.Failure(exception))
                }
        }
    }

    override suspend fun updateUser(user: User): OperationStatus {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        Firebase.auth.signOut()
    }

    override suspend fun deleteAccount() {
        Firebase.auth.currentUser!!.delete().await()
    }

    private fun createUserMap(user: User): Map<*, *> {
        return hashMapOf(
            "uid" to user.id,
            "surname" to user.surname,
            "lastname" to user.lastname,
            "email" to user.email,
            "phone" to user.phone,
            "dateOfBirth" to user.dateOfBirth,
            "aadhar" to user.aadhar,
            "houseNumber" to user.houseNumber,
            "street" to user.street,
            "area" to user.area,
            "district" to user.district,
            "city" to user.city,
            "state" to user.state,
            "pincode" to user.pincode,
            "education" to user.education,
            "route" to user.route
        )
    }
}