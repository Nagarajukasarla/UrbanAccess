package com.example.buspassapplication.response

data class UploadResponse(
    val message: String = "",
    val status: Boolean = false,
    val data: Map<String, String>? = null
)