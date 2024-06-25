package com.example.buspassapplication.response

data class RazorpayOrderResponse(
    val id: String,
    val amount: Long,
    val amountDue: Long,
    val amountPaid: Long,
    val attempts: Int,
    val createdAt: Long,
    val currency: String,
    val entity: String,
    val offerId: String?,
    val receipt: String,
    val status: String
)