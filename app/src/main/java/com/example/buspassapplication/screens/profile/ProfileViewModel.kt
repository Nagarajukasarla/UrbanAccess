package com.example.buspassapplication.screens.profile

import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val accountService: AccountService
): AppViewModel() {

}