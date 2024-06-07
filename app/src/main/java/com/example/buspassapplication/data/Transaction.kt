package com.example.buspassapplication.data

import com.example.buspassapplication.enums.TransactionEnum
import com.google.type.DateTime

data class Transaction (
    val id: String? = null,
    val transaction: TransactionEnum? = null,
    val amount: Double? = null,
    val dateTime: DateTime? = null
)
