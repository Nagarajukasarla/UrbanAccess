package com.example.buspassapplication.data

import com.example.buspassapplication.enums.PassStatus

data class UserPass (
    val id: String,
    val userId: String,
    val mrn: String,
    val name: String,
    val age: Int,
    val gender: String,
    val phone: String,
    val validity: String,
    val type: String,
    val dob: String,
    val status: PassStatus = PassStatus.PENDING,
    val divisionId: String,
    val adminId: String? = null,
    val processedAt: String? = null
)