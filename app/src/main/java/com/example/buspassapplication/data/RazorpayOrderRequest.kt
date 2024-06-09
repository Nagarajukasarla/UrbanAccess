package com.example.buspassapplication.data

import org.json.JSONObject

data class RazorpayOrderRequest(
    val amount: Long,
    val currecy: String,
    val receipt: String,
    val partialPayment: Boolean,
    val notes: JSONObject? = null
)