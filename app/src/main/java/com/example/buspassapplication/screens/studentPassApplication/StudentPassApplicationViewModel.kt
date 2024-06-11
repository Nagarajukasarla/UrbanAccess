package com.example.buspassapplication.screens.studentPassApplication

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.PaymentActivity
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.data.RazorpayOrderRequest
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.implementation.ExternalApiServiceImplementation
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.utils.OperationStatus
import com.example.buspassapplication.models.utils.RazorpayOrderResponse
import com.example.buspassapplication.screens.generalPassApplication.GeneralPassApplicationViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class StudentPassApplicationViewModel @Inject constructor(
    private val accountService: AccountService,
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
    val tenthBoard = MutableStateFlow<String?>(null)
    val yearOfPass = MutableStateFlow<String?>(null)
    val passType = MutableStateFlow<String?>(null)
    val tenthHallTicketId = MutableStateFlow<String?>(null)
    val districtOfInstitute = MutableStateFlow<String?>(null)
    val mandalOfInstitute = MutableStateFlow<String?>(null)
    val instituteAddress = MutableStateFlow<String?>(null)
    val instituteName = MutableStateFlow<String?>(null)
    val courseName = MutableStateFlow<String?>(null)
    val admissionNumber = MutableStateFlow<String?>(null)
    val currentUser: Flow<User?> = accountService.currentUser

    val popupStatus = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val contentOnFirstLine = MutableStateFlow("")
    val contentOnSecondLine = MutableStateFlow("")

    init {
        viewModelScope.launch {
            setCurrentUserDetails()
        }
    }

    private suspend fun setCurrentUserDetails() {
        currentUser?.collect { currentUser ->
            currentUser?.let { user ->
                surname.value = user.surname
                lastname.value = user.lastname
                guardian.value = user.guardian
                dateOfBirth.value = user.dateOfBirth
                gender.value = user.gender
                phone.value = user.phone
                email.value = user.email
                aadhar.value = user.aadhar
                houseNumber.value = user.houseNumber
                street.value = user.street
                area.value = user.area
                district.value = user.district
                city.value = user.city
                state.value = user.state
                pincode.value = user.pincode
                tenthBoard.value = user.education?.tenthBoard
                yearOfPass.value = user.education?.yearOfPass
                passType.value = user.education?.passType
                tenthHallTicketId.value = user.education?.tenthHallTicketId
                districtOfInstitute.value = user.education?.districtOfInstitute
                mandalOfInstitute.value = user.education?.mandalOfInstitute
                instituteAddress.value = user.education?.instituteAddress
                instituteName.value = user.education?.instituteName
                courseName.value = user.education?.courseName
                admissionNumber.value = user.education?.admissionNumber
            }
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

    fun updateTenthBoard(newTenthBoard: String) {
        tenthBoard.value = newTenthBoard
    }

    fun updateYearOfPass(newYearOfPass: String) {
        yearOfPass.value = newYearOfPass
    }

    fun updatePassType(newPassType: String) {
        passType.value = newPassType
    }

    fun updateTenthHallTicketId(newTenthHallTicketId: String) {
        tenthHallTicketId.value = newTenthHallTicketId
    }

    fun updateDistrictOfInstitute(newDistrictOfInstitute: String) {
        districtOfInstitute.value = newDistrictOfInstitute
    }

    fun updateMandalOfInstitute(newMandalOfInstitute: String) {
        mandalOfInstitute.value = newMandalOfInstitute
    }

    fun updateInstituteAddress(newInstituteAddress: String) {
        instituteAddress.value = newInstituteAddress
    }

    fun updateInstituteName(newInstituteName: String) {
        instituteName.value = newInstituteName
    }

    fun updateCourseName(newCourseName: String) {
        courseName.value = newCourseName
    }

    fun updateAdmissionNumber(newAdmissionNumber: String) {
        admissionNumber.value = newAdmissionNumber
    }
    fun updatePopupStatus(newPopupStatus: Boolean) {
        popupStatus.value = newPopupStatus
    }
    fun handlePaymentResult(paymentStatus: String, paymentId: String, errorCode: Int = -1, errorMessage: String = "", paymentData: String) {
        when (paymentStatus) {
            "success" -> {
                updatePopupStatus(true)
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
                val response = externalApiServiceImplementation.generateOrder(razorpayOrderRequest)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    Log.e("GeneralPassViewModel", "Failed to generate order: ${response.errorBody()?.string()}")
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
            amount = 90000,
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
                activity.startActivityForResult(intent,
                    GeneralPassApplicationViewModel.PAYMENT_REQUEST_CODE
                )
            } ?: Log.e("GeneralPassViewModel", "Order response is null")
        }
    }

    fun onSubmit(activity: Activity) {
        viewModelScope.launchCatching(
            block = {
                when (val result = accountService.updateUser(createUserMap())) {
                    is OperationStatus.Success -> {
                        Log.d("GeneralPassViewModel", "User updated successfully")
                        popupStatus.value = true
                        popupTitle.value = "Application Submitted"
                        contentOnFirstLine.value = "You will be notified once your"
                        contentOnSecondLine.value = "application is approved"
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
