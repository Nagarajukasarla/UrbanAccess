package com.example.buspassapplication.screens.generalPassApplication

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buspassapplication.PaymentActivity
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.data.RazorpayOrderRequest
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.implementation.ExternalApiServiceImplementation
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.utils.OperationStatus
import com.example.buspassapplication.models.utils.RazorpayOrderResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class GeneralPassApplicationViewModel @Inject constructor(
    private val accountService: AccountService,
    private val application: Application,
    private val externalApiServiceImplementation: ExternalApiServiceImplementation
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


    private suspend fun setCurrentUserData() {
        currentUser.collect { user ->
            Log.d("GeneralPassViewModel", "Current user: $user")
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


    fun callPaymentScreen(activity: Activity) {
        var obj = JSONObject(
            "{address: Hyderabad, receipt: order_rcptid_11}"
        )
        val razorpayOrderRequest = RazorpayOrderRequest(
            amount = 90000,
            currecy = "INR",
            receipt = "",
            partialPayment = false,
            notes = obj
        )
        viewModelScope.launch {
            val response = externalApiServiceImplementation.generateOrder(razorpayOrderRequest)
            if (response.isSuccessful) {
                val orderResponse = response.body()
                Log.d("GeneralPassViewModel", "Order response: $orderResponse")
                orderResponse?.let {
                    val intent = Intent(activity, PaymentActivity::class.java).apply {
                        putExtra("orderId", orderResponse.id)
                        putExtra("amount", orderResponse.amount)
                        putExtra("currency", orderResponse.currency)
                        putExtra("receipt", orderResponse.receipt)
                        putExtra("notes", orderResponse.notes.toString())
                    }
                    activity.startActivityForResult(intent, PAYMENT_REQUEST_CODE)
                }
            }
        }
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)


//        viewModelScope.launch(Dispatchers.Main) {
//        }
    }

    fun onSubmitClick(activity: Activity) {
        viewModelScope.launchCatching(
            block = {
                when (val result = accountService.updateUser(createUserMap())) {
                    is OperationStatus.Success -> {
                        Log.d("GeneralPassViewModel", "User updated successfully")
                        popupStatus.value = true
                        popupTitle.value = "Application Submitted"
                        contentOnFirstLine.value = "You will be notified once your"
                        contentOnSecondLine.value = "application is approved"
                        callPaymentScreen(activity)
                    }

                    is OperationStatus.Failure -> {
                        Log.d("GeneralPassViewModel", "Error: ${result.exception.message}")
                        popupStatus.value = true
                        popupTitle.value = "Submission Failed"
                        contentOnFirstLine.value = "Unable to submit application"
                        contentOnSecondLine.value = "Please try again later"
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
        const val PAYMENT_REQUEST_CODE = 1001
    }
}