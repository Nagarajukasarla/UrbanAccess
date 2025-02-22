package com.example.buspassapplication.models.utils

import java.lang.Exception

sealed class OperationStatus {
    data object Success: OperationStatus()
    data class Failure(val exception: Exception): OperationStatus()
}