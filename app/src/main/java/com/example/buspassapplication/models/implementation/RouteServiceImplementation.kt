package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.data.Route
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.service.RouteService
import com.example.buspassapplication.models.utils.OperationStatus
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class RouteServiceImplementation @Inject constructor(): RouteService {

    override val currentUserId: String
        get() = Firebase.auth.currentUser?.uid.orEmpty()

    override suspend fun setRoute(route: Route): OperationStatus {
        val routeDetails = hashMapOf(
            "startingPoint" to route.startingPoint,
            "destinationPoint" to route.destinationPoint,
        )

        return suspendCancellableCoroutine { continuation ->
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document(currentUserId)
                .set(mapOf("route" to routeDetails), SetOptions.merge())
                .addOnSuccessListener {
                    continuation.resume(OperationStatus.Success)
                }
                .addOnFailureListener { exception ->
                    continuation.resume(OperationStatus.Failure(exception))
                }
        }
    }

    override suspend fun getRoute(): Route? {
        return suspendCancellableCoroutine { continuation ->
            FirebaseFirestore
                .getInstance()
                .collection("users")
                .document(currentUserId)
                .get()
                .addOnSuccessListener { documentSnapshot ->
                    val route = documentSnapshot.toObject(User::class.java)?.route
                    continuation.resume(route)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }
}
