package com.example.buspassapplication.request

import com.example.buspassapplication.data.User
import com.example.buspassapplication.data.UserPass

data class ApplicationRequest(
    val user: User,
    val pass: UserPass
)