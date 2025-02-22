package com.example.buspassapplication.models.service

import com.example.buspassapplication.request.RazorpayOrderRequest
import com.example.buspassapplication.response.RazorpayOrderResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RazorpayService {
    @POST("orders")
    @Headers("Content-Type: application/json")
    fun createOrder(@Body razorpayOrderRequest: RazorpayOrderRequest): Call<RazorpayOrderResponse>
}