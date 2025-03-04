package com.example.buspassapplication.models.implementation

import android.util.Log
import com.example.buspassapplication.models.service.AdminService
import com.example.buspassapplication.request.ApplicationRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody

class AdminServiceImplementation @Inject constructor() : AdminService {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1/api/v1/auth/")  // Base URL must start with "http://" and end with a slash
        .addConverterFactory(GsonConverterFactory.create()) // Handles JSON conversion using Gson
        .build()

    // Create a delegate instance of AdminService using Retrofit
    private val adminService: AdminService = retrofit.create(AdminService::class.java)

    // Call the endpoint and handle responses/exceptions appropriately.
    override suspend fun sendApplication(request: ApplicationRequest): Response<Boolean> {
        return try {
            val response = adminService.sendApplication(request)
            if (response.isSuccessful) {
                // Wrap the (possibly null) Boolean value in a successful Response
                Response.success(response.body() ?: false)
            } else {
                // Log the error and create an error response
                val errorBodyString = response.errorBody()?.string() ?: "Unknown error"
                Log.d("AdminServiceImplementation", "Error sending application. Code: ${response.code()}, Error: $errorBodyString")
                Response.error(
                    response.code(),
                    errorBodyString.toResponseBody("application/json".toMediaTypeOrNull())
                )
            }
        } catch (e: HttpException) {
            Log.d("AdminServiceImplementation", "HttpException occurred: ${e.message}")
            Response.error(
                500,
                "HttpException occurred: ${e.message}".toResponseBody("application/json".toMediaTypeOrNull())
            )
        } catch (e: IOException) {
            Log.d("AdminServiceImplementation", "Network error occurred: ${e.message}")
            Response.error(
                500,
                "Network error occurred: ${e.message}".toResponseBody("application/json".toMediaTypeOrNull())
            )
        } catch (e: Exception) {
            Log.d("AdminServiceImplementation", "Unexpected error occurred: ${e.message}")
            Response.error(
                500,
                "Unexpected error occurred: ${e.message}".toResponseBody("application/json".toMediaTypeOrNull())
            )
        }
    }
}
