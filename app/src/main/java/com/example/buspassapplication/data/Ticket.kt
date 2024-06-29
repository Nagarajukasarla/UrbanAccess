package com.example.buspassapplication.data

import androidx.annotation.DrawableRes
import java.time.LocalDateTime


data class Ticket(
    val id: String? = null,
    val from: String? = null,
    val to: String? = null,
    val dateTime: LocalDateTime? = null,
    @DrawableRes val img: Int
)
