package com.example.buspassapplication.screens.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
) : AppViewModel() {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val showPopup = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val popupMessageOnFirstLine = MutableStateFlow("")
    val popupMessageOnSecondLine = MutableStateFlow("")


    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun updatePopupStatus(newStatus: Boolean) {
        showPopup.value = newStatus
    }


    fun onLoginClick(navController: NavHostController) {
        viewModelScope.launchCatching(
            block = {
                val taskResult = Firebase.auth.signInWithEmailAndPassword(email.value, password.value).await()
                if (taskResult.user != null) {
                    val currentUserId = taskResult.user?.uid
                    Log.d("LoginViewModel", "TaskResult: ${taskResult.user?.uid}")
                    navController.navigate(route = "${Graph.MAIN}/${currentUserId}") {
                        popUpTo(route = Graph.AUTHENTICATION){
                            inclusive = true
                        }
                    }
                }
                else {
                    showPopup.value = true
                    popupTitle.value = "An error occurred"
                    popupMessageOnSecondLine.value = "Please try again later"
                    popupMessageOnSecondLine.value = "or restart app"
                }
            },
            onError = { e ->
                when (e) {
                    is FirebaseAuthInvalidUserException -> {
                        Log.d("LoginViewModel", "User with this email does not exist.")
                        popupMessageOnFirstLine.value = "Account doesn't exists"
                        popupMessageOnSecondLine.value = "on this email"
                        showPopup.value = true
                    }

                    is FirebaseAuthInvalidCredentialsException -> {
                        Log.d("LoginViewModel", "Invalid Password")
                        popupMessageOnFirstLine.value = "Password doesn't match"
                        popupMessageOnSecondLine.value = "try again"
                        showPopup.value = true
                        updatePassword("")
                    }

                    else -> {
                        Log.d("LoginViewModel", "Login failed: ${e.message}")
                        showPopup.value = true
                        popupTitle.value = "Internal Sever Error"
                        popupMessageOnFirstLine.value = "Operation cannot be processed"
                        popupMessageOnSecondLine.value = "try again later"
                    }
                }
            }
        )
    }
}