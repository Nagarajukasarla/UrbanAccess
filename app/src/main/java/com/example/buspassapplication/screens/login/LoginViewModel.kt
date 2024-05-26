package com.example.buspassapplication.screens.login

import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
): AppViewModel() {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun onLoginClick () {
        launchCatching {
            accountService.signIn(email.value, password.value)
            // How to handle on success and on failur
        }
    }
}