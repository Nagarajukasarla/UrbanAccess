package com.example.buspassapplication.models.service

import com.example.buspassapplication.data.Education
import com.example.buspassapplication.models.utils.OperationStatus

interface StudentService {
    val currentUserId: String
    suspend fun setEducationalDetails(education: Education): OperationStatus
    suspend fun getEducationalDetails(): Education?
}