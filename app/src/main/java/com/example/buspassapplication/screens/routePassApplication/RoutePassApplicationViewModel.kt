package com.example.buspassapplication.screens.routePassApplication

import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RoutePassApplicationViewModel @Inject constructor(
    private val accountService: AccountService
) : AppViewModel()
{
    val fullname = MutableStateFlow("")
    val guardian = MutableStateFlow("")
    val dateOfBirth = MutableStateFlow("")
    val phone = MutableStateFlow("")
    val email = MutableStateFlow("")
    val address = MutableStateFlow("")
    val aadhar = MutableStateFlow("")
    val district = MutableStateFlow("")
    val mandal = MutableStateFlow("")
    val village = MutableStateFlow("")
    val pincode = MutableStateFlow("")
    val gender = MutableStateFlow("")
    val fromplace = MutableStateFlow("")
    val toplace = MutableStateFlow("")

    fun updateFullName(newFullName: String){
        fullname.value = newFullName
    }

    fun updateGuardian(newGuardian: String){
        guardian.value = newGuardian
    }

    fun updateDateOfBirth(newDateOfBirth: String){
        dateOfBirth.value = newDateOfBirth
    }

    fun updatePhone(newPhone: String){
        phone.value = newPhone
    }

    fun updateEmail(newEmail: String){
        email.value = newEmail
    }

    fun updateAddress(newAddress: String){
        address.value = newAddress
    }

    fun updateAadhar(newAadhar: String){
        aadhar.value = newAadhar
    }

    fun updateDistrict(newDistrict: String){
        district.value = newDistrict
    }

    fun updateMandal(newMandal: String){
        mandal.value = newMandal
    }

    fun updateVillage(newVillage: String){
        village.value = newVillage
    }

    fun updatePincode(newPincode: String){
        pincode.value = newPincode
    }

    fun updateGender(newGender: String){
        gender.value = newGender
    }

    fun updateFromPlace(newFromPlace: String){
        fromplace.value = newFromPlace
    }

    fun updateToPlace(newToPlace: String){
        toplace.value = newToPlace
    }

    fun onSubmit(){
        //TODO
    }

}