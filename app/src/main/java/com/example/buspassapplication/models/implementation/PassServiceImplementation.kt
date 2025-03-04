package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.models.service.PassService
import com.example.buspassapplication.models.utils.OperationStatus
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class PassServiceImplementation @Inject constructor(): PassService {
    override suspend fun createPass(userPass: UserPass): OperationStatus {
        val currentUserDocument = FirebaseFirestore
            .getInstance()
            .collection("users")
            .document(userPass.userId)

        return suspendCancellableCoroutine { continuation ->
            currentUserDocument.get()
                .addOnSuccessListener { document ->
                    val currentPasses = document.get("passes") as? List<*>
                    val updatedPasses = currentPasses?.toMutableList() ?: mutableListOf()

                    val newUserPassMap = hashMapOf(
                        "userid" to userPass.userId,
                        "id" to userPass.id,
                        "mrn" to userPass.mrn,
                        "name" to userPass.name,
                        "age" to userPass.age,
                        "dob" to userPass.dob,
                        "gender" to userPass.gender,
                        "phone" to userPass.phone,
                        "validity" to userPass.validity,
                        "type" to userPass.type,
                        "status" to userPass.status,
                        "divisionId" to userPass.divisionId
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

    override suspend fun updatePassStatus(userPass: UserPass): OperationStatus {
        TODO("Not yet implemented")
    }

    override suspend fun submitPass(userPass: UserPass): OperationStatus {
        TODO("Not yet implemented")
    }

}