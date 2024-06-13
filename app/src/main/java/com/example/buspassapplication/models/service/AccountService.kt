package com.example.buspassapplication.models.service

import android.net.Uri
import com.example.buspassapplication.data.User
import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.models.utils.OperationStatus
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<User?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email: String, password: String, firstName: String, lastName: String)
    suspend fun signOut()
    suspend fun updateUser(userMap: Map<String, Any?>): OperationStatus
    suspend fun updateUser(user: User): OperationStatus

    suspend fun createUserPass(userPass: UserPass?): OperationStatus
    suspend fun uploadImageToFirebaseStorage(imageUri: Uri): String?
    suspend fun deleteAccount()
}