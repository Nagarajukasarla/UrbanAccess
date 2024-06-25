package com.example.buspassapplication.request


data class RazorpayOrderRequest(
    val amount: Long,
    val currency: String,
    val receipt: String,
)