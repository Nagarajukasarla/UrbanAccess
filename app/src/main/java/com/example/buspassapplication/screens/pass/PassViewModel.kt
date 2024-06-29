package com.example.buspassapplication.screens.pass

import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PassViewModel @Inject constructor(
    val accountService: AccountService
) : AppViewModel() {
    val passes = accountService.currentUser
        .map { it?.passes ?: emptyList() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}
