package com.example.buspassapplication.models.implementation

import com.example.buspassapplication.data.RazorpayOrderRequest
import com.example.buspassapplication.models.service.ExternalApiService
import com.example.buspassapplication.models.utils.RazorpayOrderResponse
import com.example.buspassapplication.models.utils.UploadResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class ExternalApiServiceImplementation @Inject constructor() : ExternalApiService {

    companion object {
        const val URL = "http://192.168.0.38:5000/"
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL)
        .build()

    private val externalApiService = retrofit.create(ExternalApiService::class.java)

    override suspend fun upload(id: String): Response<UploadResponse> {
        return externalApiService.upload(id)
    }

    override suspend fun generateOrder(razorpayOrderRequest: RazorpayOrderRequest): Response<RazorpayOrderResponse> {
            return externalApiService.generateOrder(razorpayOrderRequest)
    }


}

// Usage:
//class MyViewModel : ViewModel() {
//    private val externalApiService: ExternalApiService = ExternalApiServiceImplementation()
//
//    fun performUpload(id: String) {
//        viewModelScope.launch {
//            try {
//                val response = externalApiService.upload(id)
//                if (response.isSuccessful) {
//                    val uploadResponse = response.body()
//                    // Handle the successful response
//                    println("Message: ${uploadResponse?.message}, Status: ${uploadResponse?.status}, Data: ${uploadResponse?.data}")
//                } else {
//                    // Handle the error response
//                    println("Error: ${response.errorBody()?.string()}")
//                }
//            } catch (e: Exception) {
//                // Handle the exception
//                println("Exception: ${e.message}")
//            }
//        }
//    }
//
//    fun performGenerateOrder(order: RazorpayOrderRequest) {
//        viewModelScope.launch {
//            try {
//                val response = externalApiService.generateOrder(order)
//                if (response.isSuccessful) {
//                    val uploadResponse = response.body()
//                    // Handle the successful response
//                    println("Message: ${uploadResponse?.message}, Status: ${uploadResponse?.status}, Data: ${uploadResponse?.data}")
//                } else {
//                    // Handle the error response
//                    println("Error: ${response.errorBody()?.string()}")
//                }
//            } catch (e: Exception) {
//                // Handle the exception
//                println("Exception: ${e.message}")
//            }
//        }
//    }
//}
