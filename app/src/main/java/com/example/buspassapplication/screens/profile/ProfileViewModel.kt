package com.example.buspassapplication.screens.profile

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.R
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
class ProfileViewModel @Inject constructor(
    private val accountService: AccountService
): AppViewModel() {

    val surname = MutableStateFlow<String?>(null)
    val lastname = MutableStateFlow<String?>(null)
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

    val isEditable = MutableStateFlow(false)
    val popupStatus = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val contentOnFirstLine = MutableStateFlow("")
    val contentOnSecondLine = MutableStateFlow("")

    val profileResourceId = R.drawable.krishna

    val selectedImageUri = MutableStateFlow<Uri?>(Uri.EMPTY)
    val downloadUrl: MutableStateFlow<String?> = MutableStateFlow(null)

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

    fun updateIsEditable(newIsEditable: Boolean) {
        isEditable.value = newIsEditable
    }

    fun updatePopupStatus(status: Boolean) {
        popupStatus.value = status
    }

    private suspend fun setCurrentUserData() {
        currentUser.collect { user ->
            Log.d("GeneralPassViewModel", "Current user: $user")
            user?.let {
                surname.value = it.surname
                lastname.value = it.lastname
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
                selectedImageUri.value = it.imageUri
            }
        }
    }

    private fun resetCurrentUserData() {
        surname.value = null
        lastname.value = null
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

    private fun createUserMap(): Map<String, Any?> {
        return hashMapOf(
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
            "pincode" to pincode.value,
            "imageUrl" to downloadUrl.value,
        )
    }

    suspend fun updateUserProfileImage() {
        downloadUrl.value = selectedImageUri.value?.let { uri ->
            accountService.uploadImageToFirebaseStorage(
                uri
            )
        }
        Log.d("ProfileViewModel", "Download URL: $downloadUrl")
    }

    fun onSaveClick() {
        viewModelScope.launch {
            updateUserProfileImage()
            when(val result = accountService.updateUser(createUserMap())) {
                is OperationStatus.Success -> {
                    Log.d("ProfileViewModel", "User data updated successfully")
                    updateIsEditable(false)
                    popupStatus.value = true
                    popupTitle.value = "Updated"
                    contentOnFirstLine.value = "Your data updated"
                    contentOnSecondLine.value = "successfully"
                }
                is OperationStatus.Failure -> {
                    Log.e("ProfileViewModel", "Failed to update user data: ${result.exception}")
                    popupStatus.value = true
                    popupTitle.value = "Error"
                    contentOnFirstLine.value = "Failed to update"
                    contentOnSecondLine.value = "user data"
                }
            }
        }
    }
}