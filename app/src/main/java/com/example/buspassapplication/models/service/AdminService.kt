package com.example.buspassapplication.models.service

import com.example.buspassapplication.request.ApplicationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AdminService {
    @POST("send-application")
    suspend fun sendApplication(@Body request: ApplicationRequest): Response<Boolean>
}