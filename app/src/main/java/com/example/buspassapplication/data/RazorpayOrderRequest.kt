package com.example.buspassapplication.data


data class RazorpayOrderRequest(
    val amount: Long,
    val currency: String,
    val receipt: String,
)