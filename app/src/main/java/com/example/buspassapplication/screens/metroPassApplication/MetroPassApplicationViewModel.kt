package com.example.buspassapplication.screens.metroPassApplication

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.PaymentActivity
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.request.RazorpayOrderRequest
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.implementation.RazorpayServiceImplementation
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.utils.OperationStatus
import com.example.buspassapplication.response.RazorpayOrderResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MetroPassApplicationViewModel @Inject constructor(
    private val accountService: AccountService,
    private val razorpayServiceImplementation: RazorpayServiceImplementation
) : AppViewModel() {

    val surname = MutableStateFlow<String?>(null)
    val lastname = MutableStateFlow<String?>(null)
    val guardian = MutableStateFlow<String?>(null)
    val dateOfBirth = MutableStateFlow<String?>(null)
    val gender = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val aadhar = MutableStateFlow<String?>(null)
    val houseNumber = MutableStateFlow<String?>(null)
    val street = MutableStateFlow<String?>(null)
    val area = MutableStateFlow<String?>(null)
    val district = MutableStateFlow<String?>(null)
    val city = MutableStateFlow<String?>(null)
    val state = MutableStateFlow<String?>(null)
    val pincode = MutableStateFlow<String?>(null)
    val currentUser: Flow<User?> = accountService.currentUser

    val popupStatus = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val contentOnFirstLine = MutableStateFlow("")
    val contentOnSecondLine = MutableStateFlow("")
    val paymentConfirmationPopupStatus = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            setCurrentUserData()
        }
    }

    fun updateSurname(newSurname: String) {
        surname.value = newSurname
    }

    fun updateLastname(newLastname: String) {
        lastname.value = newLastname
    }

    fun updateGuardian(newGuardian: String) {
        guardian.value = newGuardian
    }

    fun updateDateOfBirth(newDateOfBirth: String) {
        dateOfBirth.value = newDateOfBirth
    }

    fun updateGender(newGender: String) {
        gender.value = newGender
    }

    fun updatePhone(newPhone: String) {
        phone.value = newPhone
    }

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updateAadhar(newAadhar: String) {
        aadhar.value = newAadhar
    }

    fun updateHouseNumber(newHouseNumber: String) {
        houseNumber.value = newHouseNumber
    }

    fun updateStreet(newStreet: String) {
        street.value = newStreet
    }

    fun updateArea(newArea: String) {
        area.value = newArea
    }

    fun updateDistrict(newDistrict: String) {
        district.value = newDistrict
    }

    fun updateCity(newCity: String) {
        city.value = newCity
    }

    fun updateState(newState: String) {
        state.value = newState
    }

    fun updatePincode(newPincode: String) {
        pincode.value = newPincode
    }
    fun updatePopupStatus(newPopupStatus: Boolean) {
        popupStatus.value = newPopupStatus
    }

    private suspend fun setCurrentUserData() {
        currentUser.collect { user ->
            user?.let {
                surname.value = it.surname
                lastname.value = it.lastname
                guardian.value = it.guardian
                dateOfBirth.value = it.dateOfBirth
                gender.value = it.gender
                phone.value = it.phone
                email.value = it.email
                aadhar.value = it.aadhar
                houseNumber.value = it.houseNumber
                street.value = it.street
                area.value = it.area
                city.value = it.city
                district.value = it.district
                state.value = it.state
                pincode.value = it.pincode
            }
        }
    }

    private fun resetCurrentUserData() {
        surname.value = null
        lastname.value = null
        guardian.value = null
        dateOfBirth.value = null
        gender.value = null
        phone.value = null
        email.value = null
        aadhar.value = null
        houseNumber.value = null
        street.value = null
        area.value = null
        city.value = null
        district.value = null
        state.value = null
        pincode.value = null
    }

    fun handlePaymentResult(paymentStatus: String, paymentId: String, errorCode: Int = -1, errorMessage: String = "", paymentData: String) {
        when (paymentStatus) {
            "success" -> {
                //updatePopupStatus(true)
                popupTitle.value = "Application Submitted"
                contentOnFirstLine.value = "You will be notified once your"
                contentOnSecondLine.value = "application is approved"
                Log.d("GeneralPassViewModel", "Payment successful: $paymentId, data: $paymentData")
            }
            "error" -> {
//                popupStatus.value = true
                popupTitle.value = "Submission Failed"
                contentOnFirstLine.value = "Contact customer support"
                contentOnSecondLine.value = "with support@urbanpass.com"
                Log.e("GeneralPassViewModel", "Payment error: $errorCode, message: $errorMessage, data: $paymentData")
            }
            else -> {
                Log.e("GeneralPassViewModel", "Unknown payment status")
            }
        }
    }
    private suspend fun generateOrder(razorpayOrderRequest: RazorpayOrderRequest): RazorpayOrderResponse? {
        return withContext(Dispatchers.IO) {
            try {
                val response = razorpayServiceImplementation.createOrder(razorpayOrderRequest)
                if (response != null && response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("GeneralPassViewModel", "Failed to generate order: ${response?.errorBody()?.string()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("GeneralPassViewModel", "Exception during order generation: ${e.message}")
                null
            }
        }
    }
    private fun callPaymentScreen(activity: Activity) {
        val razorpayOrderRequest = RazorpayOrderRequest(
            amount = 140000,
            currency = "INR",
            receipt = "",
        )

        viewModelScope.launch {
            val orderResponse = generateOrder(razorpayOrderRequest)
            orderResponse?.let { response ->
                Log.d("GeneralPassViewModel", "Order response: $response")
                val intent = Intent(activity, PaymentActivity::class.java).apply {
                    putExtra("orderId", response.id)
                    putExtra("amount", response.amount)
                    putExtra("currency", response.currency)
                    putExtra("receipt", response.receipt)
                }
                activity.startActivityForResult(intent, PAYMENT_REQUEST_CODE)
            } ?: Log.e("GeneralPassViewModel", "Order response is null")
        }
    }


    fun onClickSubmit(activity: Activity) {
        viewModelScope.launchCatching(
            block = {
                when (val result = accountService.updateUser(createUserMap())) {
                    is OperationStatus.Success -> {
                        Log.d("MetroPassViewModel", "User updated successfully")
//                        popupStatus.value = true
//                        popupTitle.value = "Application Submitted"
//                        contentOnFirstLine.value = "You will be notified once your"
//                        contentOnSecondLine.value = "application is approved"
                        callPaymentScreen(activity)
                        resetCurrentUserData()
                    }
                    is OperationStatus.Failure -> {
                        Log.d("MetroPassViewModel", "Error: ${result.exception.message}")
//                        popupStatus.value = true
//                        popupTitle.value = "Submission Failed"
//                        contentOnFirstLine.value = "Unable to submit application"
//                        contentOnSecondLine.value = "Please try again later"
                    }
                }
            },
            onError = { exception ->
                Log.d("GeneralPassViewModel", "Error: ${exception.message}")
            }
        )
    }
    private fun createUserMap(): Map<String, Any?> {
        return hashMapOf(
            "guardian" to guardian.value,
             "dateOfBirth" to dateOfBirth.value,
            "aadhar" to aadhar.value,
            "gender" to gender.value,
            "phone" to phone.value,
            "houseNumber" to houseNumber.value,
            "street" to street.value,
            "area" to area.value,
            "city" to city.value,
            "district" to district.value,
            "state" to state.value,
            "pincode" to pincode.value
        )
    }
    companion object {
        const val PAYMENT_REQUEST_CODE = 1002
    }
}
