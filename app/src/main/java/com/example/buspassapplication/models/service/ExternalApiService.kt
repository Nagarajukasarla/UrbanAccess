package com.example.buspassapplication.models.service

import com.example.buspassapplication.data.RazorpayOrderRequest
import com.example.buspassapplication.models.utils.RazorpayOrderResponse
import com.example.buspassapplication.models.utils.UploadResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ExternalApiService {

    @GET("upload/{id}")
    suspend fun upload(@Path("id") id : String): Response<UploadResponse>

    @POST("generate-order")
    suspend fun generateOrder(@Body razorpayOrderRequest: RazorpayOrderRequest): Response<RazorpayOrderResponse>

}



// Usage
//try {
//    val response = withContext(Dispatchers.IO) {
//        Log.d("LoginViewModel", accountService.currentUserId)
//        ExternalApiService.create().upload(accountService.currentUserId)
//    }
//
//    if (response.isSuccessful) {
//        val uploadResponse = response.body()
//        // Handle success
//        Log.d("LoginViewModel","Upload successful: ${uploadResponse?.message}, URL: ${uploadResponse?.url}")
//    } else {
//        // Handle failure
//        Log.d("LoginViewModel","Upload failed with response code: ${response.code()}")
//    }
//
//} catch (e: CancellationException) {
//    // Handle coroutine cancellation
//    Log.d("LoginViewModel","Upload failed: Job was cancelled")
//} catch (e: Exception) {
//    // Handle other exceptions
//    Log.d("LoginViewModel","Upload failed: ${e.message}")
//}