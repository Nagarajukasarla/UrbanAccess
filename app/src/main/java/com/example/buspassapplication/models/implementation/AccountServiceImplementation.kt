package com.example.buspassapplication.models.implementation

import android.net.Uri
import android.util.Log
import com.example.buspassapplication.data.Education
import com.example.buspassapplication.data.User
import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.utils.OperationStatus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

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
                                launch {
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

                                        val imageUri = try {
                                            val storageRef = FirebaseStorage.getInstance()
                                                .getReference("images/${firebaseUser.uid}")
                                            val imageUrl = storageRef.downloadUrl.await()
                                            imageUrl
                                        } catch (e: Exception) {
                                            Uri.EMPTY
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
                                            imageUri = imageUri,
                                            passes = (it.get("passes") as? List<Map<String, Any>>)?.map { passMap ->
                                                UserPass(
                                                    userId = currentUserId,
                                                    id = passMap["id"] as? String ?: "",
                                                    mrn = passMap["mrn"] as? String ?: "",
                                                    name = passMap["name"] as? String ?: "",
                                                    age = (passMap["age"] as? Long)?.toInt() ?: 0,
                                                    gender = passMap["gender"] as? String ?: "",
                                                    phone = passMap["phone"] as? String ?: "",
                                                    validity = passMap["validity"] as? String ?: "",
                                                    type = passMap["type"] as? String ?: "",
                                                    divisionId = passMap["divisionId"] as? String ?: "",
                                                    dob = passMap["dob"] as? String ?: ""
                                                )
                                            } ?: emptyList()
                                        )
                                    }
                                    trySend(user)
                                }
                            }.addOnFailureListener {
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

    override suspend fun uploadImageToFirebaseStorage(imageUri: Uri): String? =
        suspendCancellableCoroutine { continuation ->
            val storageReference =
                FirebaseStorage.getInstance().reference.child("images/${currentUserId}")
            val uploadTask = storageReference.putFile(imageUri)

            uploadTask.continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                storageReference.downloadUrl
            }.addOnCompleteListener { task ->
                if (continuation.isActive) {
                    if (task.isSuccessful) {
                        Log.d("AccountService", "Image uploaded successfully")
                        Log.d("AccountService", task.result.toString())
                        continuation.resume(task.result.toString())
                    } else {
                        continuation.resume(null)
                    }
                }
            }.addOnFailureListener {
                if (continuation.isActive) {
                    Log.e("AccountService", "Image upload failed", it)
                    continuation.resumeWithException(it)
                }
            }
        }


    override suspend fun createUserPass(userPass: UserPass?): OperationStatus {
        val currentUserDocument = FirebaseFirestore
            .getInstance()
            .collection("users")
            .document(currentUserId)

        return suspendCancellableCoroutine { continuation ->
            currentUserDocument.get()
                .addOnSuccessListener { document ->
                    val currentPasses = document.get("passes") as? List<Map<String, Any?>>
                    val updatedPasses = currentPasses?.toMutableList() ?: mutableListOf()

                    val newUserPassMap = hashMapOf(

                        "id" to userPass?.id,
                        "mrn" to userPass?.mrn,
                        "name" to userPass?.name,
                        "age" to userPass?.age,
                        "dob" to userPass?.dob,
                        "gender" to userPass?.gender,
                        "phone" to userPass?.phone,
                        "validity" to userPass?.validity,
                        "type" to userPass?.type
                    )

                    updatedPasses.add(newUserPassMap)

                    currentUserDocument
                        .set(mapOf("passes" to updatedPasses), SetOptions.merge())
                        .addOnSuccessListener {
                            continuation.resume(OperationStatus.Success)
                        }
                        .addOnFailureListener { exception ->
                            continuation.resume(OperationStatus.Failure(exception))
                        }
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