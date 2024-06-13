package com.example.buspassapplication.data

import android.net.Uri

data class User(
    val id: String? = null,
    val surname: String? = null,
    val lastname: String? = null,
    val dateOfBirth: String? = null,
    val gender: String? = null,
    val guardian: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val aadhar: String? = null,
    val houseNumber: String? = null,
    val street: String? = null,
    val area: String? = null,
    val district: String? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val pincode: String? = null,
    val route: Route? = null,
    val education: Education? = null,
    val imageUri: Uri = Uri.EMPTY,
    val pass: UserPass? = null
)

