package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.models.service.RazorpayService
import com.example.buspassapplication.request.RazorpayOrderRequest
import com.example.buspassapplication.response.RazorpayOrderResponse
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RazorpayServiceImplementation @Inject constructor() {

    private val service: RazorpayService by lazy {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val credentials =
                    Credentials.basic("rzp_test_JmTvsyFwmcuMTd", "bkJLUX4tTiILOvSHLZIITwmK")
                val request = original.newBuilder()
                    .header("Authorization", credentials)
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.razorpay.com/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(RazorpayService::class.java)
    }

    fun createOrder(razorpayOrderRequest: RazorpayOrderRequest): Response<RazorpayOrderResponse>? {
        return try {
            service.createOrder(razorpayOrderRequest).execute()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}