package com.example.buspassapplication.screens.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import com.google.firebase.FirebaseException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService
) : AppViewModel() {

    val email = MutableStateFlow("")
    val firstName = MutableStateFlow("")
    val lastName = MutableStateFlow("")
    val password = MutableStateFlow("")
    val confirmPassword = MutableStateFlow("")

    val popupStatusForPasswordMatch = MutableStateFlow(false)
    val popupStatusSignupAction = MutableStateFlow(false)

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updateFirstname(newFirstName: String) {
        firstName.value = newFirstName
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

    fun onLoginClick() {
        if (!isPasswordMatched()) {
            popupStatusForPasswordMatch.value = true
            return
        }
        viewModelScope.launchCatching(
            block = {
                accountService.signUp(email.value, password.value, firstName.value, lastName.value)
            },
            onError = { e ->
                when (e) {
                    is FirebaseException -> {
                        Log.d("Signup Screen", "Exception: $e")
                        popupStatusSignupAction.value = true
                    }
                }
            }
        )
    }
}