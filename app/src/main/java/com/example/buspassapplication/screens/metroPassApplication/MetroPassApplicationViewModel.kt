package com.example.buspassapplication.screens.metroPassApplication

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buspassapplication.app.launchCatching
import com.example.buspassapplication.data.User
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import com.example.buspassapplication.models.utils.OperationStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MetroPassApplicationViewModel @Inject constructor(
    private val accountService: AccountService
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
    fun onClickSubmit() {
        viewModelScope.launchCatching(
            block = {
                when (val result = accountService.updateUser(createUserMap())) {
                    is OperationStatus.Success -> {
                        Log.d("MetroPassViewModel", "User updated successfully")
                        popupStatus.value = true
                        popupTitle.value = "Application Submitted"
                        contentOnFirstLine.value = "You will be notified once your"
                        contentOnSecondLine.value = "application is approved"
                    }
                    is OperationStatus.Failure -> {
                        Log.d("MetroPassViewModel", "Error: ${result.exception.message}")
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
}
