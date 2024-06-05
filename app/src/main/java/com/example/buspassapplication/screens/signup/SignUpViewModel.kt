package com.example.buspassapplication.screens.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService
) : AppViewModel() {

    val email = MutableStateFlow("")
    val surname = MutableStateFlow("")
    val lastName = MutableStateFlow("")
    val password = MutableStateFlow("")
    val confirmPassword = MutableStateFlow("")

    val passwordMismatch = MutableStateFlow(false)
    val accountCreated = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val popupMessageOnFirstLine = MutableStateFlow("")
    val popupMessageOnSecondLine = MutableStateFlow("")
    val popupStatus = MutableStateFlow(false)

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updateSurname(newSurname: String) {
        surname.value = newSurname
    }

    fun updateLastname(newLastName: String) {
        lastName.value = newLastName
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun updateConfirmPassword(newConfirmPassword: String) {
        confirmPassword.value = newConfirmPassword
    }

    fun isPasswordMatched(): Boolean {
        return password.value.equals(confirmPassword.value)
    }

    fun resetPopup() {
        popupTitle.value = ""
        popupMessageOnFirstLine.value = ""
        popupMessageOnSecondLine.value = ""
        popupStatus.value = false
    }

    fun resetForm() {
        email.value = ""
        surname.value = ""
        lastName.value = ""
        password.value = ""
        confirmPassword.value = ""
    }

    fun onSignupClick() {
        if (!isPasswordMatched()) {
            popupTitle.value = "Password Mismatch"
            popupMessageOnFirstLine.value = "Please ensure that confirm password"
            popupMessageOnSecondLine.value = "match original password"
            popupStatus.value = true
            passwordMismatch.value = true
            accountCreated.value = false
            return
        }
        viewModelScope.launchCatching(
            block = {
                runCatching {
                    accountService.signUp(
                        email.value,
                        password.value,
                        surname.value,
                        lastName.value
                    )
                    resetForm()
                }.onSuccess {
                    popupTitle.value = "Account Created"
                    popupMessageOnFirstLine.value = "Please login to access"
                    popupMessageOnSecondLine.value = "the application"
                    popupStatus.value = true
                    accountCreated.value = true
                    passwordMismatch.value = false
                }.onFailure { e ->
                    when (e) {
                        is FirebaseAuthUserCollisionException -> {
                            Log.d("SignupViewModel", "User already exist with this email")
                            popupTitle.value = "User already exist"
                            popupMessageOnFirstLine.value = "Please login to access"
                            popupMessageOnSecondLine.value = "the application"
                            popupStatus.value = true
                            accountCreated.value = false
                            passwordMismatch.value = false
                        }

                        is FirebaseException -> {
                            Log.d("SignupViewModel", "FirebaseException: $e")
                            popupTitle.value = "Unknown Error occurred"
                            popupMessageOnFirstLine.value = "Please try again later"
                            popupMessageOnSecondLine.value = "or contact support"
                            popupStatus.value = true
                            accountCreated.value = false
                            passwordMismatch.value = false
                        }

                        else -> {
                            Log.d("SignupViewModel", "Unknown Error occurred: $e")
                            popupTitle.value = "Unknown Error occurred"
                            popupMessageOnFirstLine.value = "Please try again later"
                            popupMessageOnSecondLine.value = "or contact support"
                            popupStatus.value = true
                            accountCreated.value = false
                            passwordMismatch.value = false
                        }
                    }
                }
            },
            onError = { e ->
                Log.d("SignupViewModel", "Uncaught error occurred: $e")
            }
        )
    }
}