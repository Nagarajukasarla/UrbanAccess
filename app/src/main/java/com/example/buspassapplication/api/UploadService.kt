package com.example.buspassapplication.api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

data class UploadResponse(val message: String, val url: String)

interface UploadService {
    @GET("upload/{id}")
    suspend fun upload(@Path("id") id: String): Response<UploadResponse>

    companion object {
        private const val BASE_URL = "http://192.168.0.212:5000/"

        fun create(): UploadService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(UploadService::class.java)
        }
    }
}
// Usage
//try {
//    val response = withContext(Dispatchers.IO) {
//        Log.d("LoginViewModel", accountService.currentUserId)
//        UploadService.create().upload(accountService.currentUserId)
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