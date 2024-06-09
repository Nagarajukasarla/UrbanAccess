package com.example.buspassapplication.data

import androidx.annotation.DrawableRes
import com.google.type.DateTime


data class Ticket (
    val id: String? = null,
    val from: String? = null,
    val to: String? = null,
    val dateTime: DateTime? = null,
    @DrawableRes val img: Int
)
