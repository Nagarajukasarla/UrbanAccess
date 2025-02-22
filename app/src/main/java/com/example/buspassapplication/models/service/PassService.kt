package com.example.buspassapplication.models.service

import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.models.utils.OperationStatus

interface PassService {

    suspend fun createPass(userPass: UserPass): OperationStatus
    suspend fun updatePassStatus(userPass: UserPass): OperationStatus
    suspend fun submitPass(userPass: UserPass): OperationStatus
}