package com.example.buspassapplication.screens.metroPassApplication

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.PaymentActivity
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.request.RazorpayOrderRequest
import com.example.buspassapplication.data.User
import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.enums.GenderEnum
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.implementation.RazorpayServiceImplementation
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.service.PassService
import com.example.buspassapplication.models.utils.OperationStatus
import com.example.buspassapplication.models.utils.ValidationResult
import com.example.buspassapplication.models.utils.ValidationUtils
import com.example.buspassapplication.response.RazorpayOrderResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MetroPassApplicationViewModel @Inject constructor(
    private val accountService: AccountService,
    private val passService: PassService,
    private val razorpayServiceImplementation: RazorpayServiceImplementation,
    private val savedStateHandle: SavedStateHandle

) : AppViewModel() {

    val surname = MutableStateFlow<String?>(null)
    val lastname = MutableStateFlow<String?>(null)
    val guardian = MutableStateFlow<String?>(null)
    val dateOfBirth = MutableStateFlow<String?>(null)
    val gender = MutableStateFlow<GenderEnum?>(null)
    val phone = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val aadhar = MutableStateFlow<String?>(null)
    val houseNumber = MutableStateFlow<String?>(null)
    val duration = MutableStateFlow<String?>(null)
    val street = MutableStateFlow<String?>(null)
    val area = MutableStateFlow<String?>(null)
    val district = MutableStateFlow<String?>(null)
    val city = MutableStateFlow<String?>(null)
    val state = MutableStateFlow<String?>(null)
    val pincode = MutableStateFlow<String?>(null)
    val amount = MutableStateFlow<Long?>(null)
    val paymentConfirmationStatus = MutableStateFlow(false)
    val currentUser: Flow<User?> = accountService.currentUser

    val popupStatus = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val contentOnFirstLine = MutableStateFlow("")
    val contentOnSecondLine = MutableStateFlow("")
    private val currentUserPass = MutableStateFlow<UserPass?>(null)    
    val shouldRecompose = MutableStateFlow(false)
    val paymentConfirmationPopupStatus = MutableStateFlow(false)

    val surnameError = MutableStateFlow<String?>(null)
    val lastnameError = MutableStateFlow<String?>(null)
    val guardianError = MutableStateFlow<String?>(null)
    val dateOfBirthError = MutableStateFlow<String?>(null)
    val genderError = MutableStateFlow<String?>(null)
    val phoneError = MutableStateFlow<String?>(null)   
    val emailError = MutableStateFlow<String?>(null)
    val aadharError = MutableStateFlow<String?>(null)
    val houseNumberError = MutableStateFlow<String?>(null)
    val streetError = MutableStateFlow<String?>(null)
    val areaError = MutableStateFlow<String?>(null)
    val districtError = MutableStateFlow<String?>(null) 
    val cityError = MutableStateFlow<String?>(null)
    val stateError = MutableStateFlow<String?>(null)
    val pincodeError = MutableStateFlow<String?>(null)
    val durationError = MutableStateFlow<String?>(null)
    
    
    
    init {
        viewModelScope.launch {
            setCurrentUserData()
        }
    }

    fun triggerRecomposition() {
        shouldRecompose.value = true
    }

    fun clearRecompositionFlag() {
        shouldRecompose.value = false
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
        gender.value = GenderEnum.entries.find { it.value == newGender }
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

    fun updateDuration(newDuration: String) {
        duration.value = newDuration
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

    fun updatePaymentConfirmationStatus(newPaymentConfirmationStatus: Boolean) {
        paymentConfirmationStatus.value = newPaymentConfirmationStatus
    }

    fun updatePopupStatus(newPopupStatus: Boolean) {
        popupStatus.value = newPopupStatus
    }
    private fun validateFields(): Boolean {
        var isValid = true

        when (val surnameValidation = ValidationUtils.validateSurname(surname.value)) {
            is ValidationResult.Error -> {
                surnameError.value = surnameValidation.message
                isValid = false
            }
            else -> surnameError.value = null
        }

        when (val lastnameValidation = ValidationUtils.validateLastname(lastname.value)) {
            is ValidationResult.Error -> {
                lastnameError.value = lastnameValidation.message
                isValid = false
            }
            else -> lastnameError.value = null
        }

        // Call validation for other fields

        when (val dobValidation = ValidationUtils.validateDateOfBirth(dateOfBirth.value)) {
            is ValidationResult.Error -> {
                dateOfBirthError.value = dobValidation.message
                isValid = false
            }
            else -> dateOfBirthError.value = null
        }

        when (val phoneValidation = ValidationUtils.validatePhone(phone.value)) {
            is ValidationResult.Error -> {
                phoneError.value = phoneValidation.message
                isValid = false
            }
            else -> phoneError.value = null
        }

        when (val emailValidation = ValidationUtils.validateEmail(email.value)) {
            is ValidationResult.Error -> {
                emailError.value = emailValidation.message
                isValid = false
            }
            else -> emailError.value = null
        }

        when (val aadharValidation = ValidationUtils.validateAadhar(aadhar.value)) {
            is ValidationResult.Error -> {
                aadharError.value = aadharValidation.message
                isValid = false
            }
            else -> aadharError.value = null
        }

        when (val durationValidation = ValidationUtils.validateDuration(duration.value)) {
            is ValidationResult.Error -> {
                durationError.value = durationValidation.message
                isValid = false
            }
            else -> durationError.value = null
        }
        return isValid
    }

    private suspend fun setCurrentUserData() {
        currentUser.collect { user ->
            user?.let {
                surname.value = it.surname
                lastname.value = it.lastname
                guardian.value = it.guardian
                dateOfBirth.value = it.dateOfBirth
                gender.value = GenderEnum.entries.find { enum -> enum.value== it.gender }
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
        duration.value = null
    }
    private fun updatePopupStatusAsSuccess() {
        viewModelScope.launch {
            delay(2000)
            popupStatus.value = true
            popupTitle.value = "Application Submitted"
            contentOnFirstLine.value = "You will be notified once your"
            contentOnSecondLine.value = "application is approved"
        }
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
    private suspend fun generateUserPass(): OperationStatus {
        if (currentUserPass.value == null) return OperationStatus.Failure(Exception("No Pass is Generated"));
        return withContext(Dispatchers.IO) {
            try {
                val response = passService.createPass(currentUserPass.value!!)
                when (response) {
                    is OperationStatus.Success -> {
                        Log.d("MetroPassViewModel", "User pass generated successfully")
                    }

                    is OperationStatus.Failure -> {
                        Log.e("MetroPassViewModel", "Error: ${response.exception.message}")
                    }
                }
                resetCurrentUserData()
                response
            } catch (e: Exception) {
                Log.e("MetroPassViewModel", "Exception during user pass generation: ${e.message}")
                OperationStatus.Failure(e)
            }
        }
    }
    fun onClickSubmit() {
        updatePaymentConfirmationStatus(true)
        calculatePrice()
    }


    fun onClickPurchaseConfirm(activity: Activity) {
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
    private fun createUserPass() {
        currentUserPass.value = UserPass(
            userId = accountService.currentUserId,
            name = surname.value + " " + lastname.value,
            id = generateId(),
            mrn = generateMrn(),
            age = calculateAge(dateOfBirth.value ?: ""),
            gender = gender.value.toString(),
            phone = phone.value ?: "",
            type = "general",
            dob = dateOfBirth.value ?: "",
            validity = calculateDuration(duration.value)
        )
        Log.d("MetroPassViewModel", "User pass created at 320line: ${currentUserPass.value}")
    }

    private fun calculateAge(dateOfBirth: String): Int {
        if (dateOfBirth.isEmpty()) return 0
        val dateParts = dateOfBirth.split("-")
        val year = dateParts[0].toInt()
        val month = dateParts[1].toInt()
        val day = dateParts[2].toInt()

        val birthDate = Calendar.getInstance().apply {
            set(year, month - 1, day) // Calendar month is 0-based
        }

        val currentDate = Calendar.getInstance()
        var age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)

        if (currentDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--
        }

        Log.d("MetroPassViewModel", "Age: $age")
        return age
    }

    private fun calculatePrice() {
        when (duration.value?.lowercase(Locale.getDefault())) {
            "weekly" -> {
                amount.value = 15000
            }

            "monthly" -> {
                amount.value = 45000
            }

            "quarterly" -> {
                amount.value = 150000
            }

            else -> amount.value = 0
        }
    }

    private fun calculateDuration(duration: String?): String {
        val currentDate = Calendar.getInstance()
        val currentDay = currentDate.get(Calendar.DAY_OF_MONTH)

        when (duration?.lowercase(Locale.getDefault())) {
            "weekly" -> {
                currentDate.add(Calendar.WEEK_OF_YEAR, 1)
            }

            "monthly" -> {
                currentDate.add(Calendar.MONTH, 1)
            }

            "quarterly" -> {
                currentDate.add(Calendar.MONTH, 3)
            }

            "yearly" -> {
                currentDate.add(Calendar.YEAR, 1)
            }

            else -> return ""
        }

        // Ensure that the day of the month remains the same
        currentDate.set(Calendar.DAY_OF_MONTH, currentDay)

        // Adjust if setting the day causes an invalid date (e.g., setting February 30)
        if (currentDate.get(Calendar.DAY_OF_MONTH) != currentDay) {
            currentDate.set(
                Calendar.DAY_OF_MONTH,
                currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)
            )
        }

        val nextMonth = currentDate.get(Calendar.MONTH) + 1 // Calendar month is 0-based
        val nextYear = currentDate.get(Calendar.YEAR)
        Log.d("MetroPassViewModel", "Next date: $currentDay-$nextMonth-$nextYear")
        return String.format("%02d-%02d-%d", currentDay, nextMonth, nextYear)
    }

    private fun generateId(): String {
        val prefix = "ID9371"
        val random = (10000..99999).random()
        return "$prefix$random"
    }

    private fun generateMrn(): String {
        val prefix = "MRN8519"
        val random = (1000..9999).random()
        return "$prefix$random"
    }

    companion object {
        const val PAYMENT_REQUEST_CODE = 1002
    }
}
