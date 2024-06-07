package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.data.Education
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.service.StudentService
import com.example.buspassapplication.models.utils.OperationStatus
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


class StudentServiceImplementation @Inject constructor() : StudentService {
    override val currentUserId: String
        get() = Firebase.auth.currentUser?.uid.orEmpty()

    override suspend fun setEducationalDetails(education: Education): OperationStatus {

        val educationalDetails = hashMapOf(
            "studentId" to education.studentId,
            "tenthBoard" to education.tenthBoard,
            "yearOfPass" to education.yearOfPass,
            "passType" to education.passType,
            "tenthHallTicketId" to education.tenthHallTicketId,
            "districtOfInstitute" to education.districtOfInstitute,
            "mandalOfInstitute" to education.mandalOfInstitute,
            "instituteAddress" to education.instituteAddress,
            "instituteName" to education.instituteName,
            "courseName" to education.courseName,
            "admissionNumber" to education.admissionNumber
        )
        return suspendCancellableCoroutine { continuation ->
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document(currentUserId)
                .set(mapOf("education" to educationalDetails), SetOptions.merge())
                .addOnSuccessListener {
                    continuation.resume(OperationStatus.Success)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(OperationStatus.Failure(exception))
                }
        }
    }

    override suspend fun getEducationalDetails(): Education? {
        return suspendCancellableCoroutine { continuation ->
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document(currentUserId)
                .get()
                .addOnSuccessListener { documentSnapshot ->
                    val education = documentSnapshot.toObject(User::class.java)?.education
                    continuation.resume(education)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
}