package com.example.buspassapplication.models.utils

import org.json.JSONObject


// razorpay response for order creation
//{
//    "amount": 50000,
//    "amount_due": 50000,
//    "amount_paid": 0,
//    "attempts": 0,
//    "created_at": 1717898082,
//    "currency": "INR",
//    "entity": "order",
//    "id": "order_OKUKKxl4oTzaeO",
//    "notes": {
//    "key1": "value3",
//    "key2": "value2"
//},
//    "offer_id": null,
//    "receipt": "receipt#1",
//    "status": "created"
//}
data class RazorpayOrderResponse(
    val id: String,
    val amount: Long,
    val amountDue: Long,
    val amountPaid: Long,
    val attempts: Int,
    val createdAt: Long,
    val currency: String,
    val entity: String,
    val notes: JSONObject,
    val offerId: String?,
    val receipt: String,
    val status: String
)