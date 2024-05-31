package com.example.buspassapplication.screens.studentPassApplication

import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class StudentPassApplicationViewModel @Inject constructor(
    private val accountService: AccountService
) : AppViewModel(){
    val fullName = MutableStateFlow("")
    val guardian = MutableStateFlow("")
    val dateOfBirth = MutableStateFlow("")
    val phone = MutableStateFlow("")
    val email = MutableStateFlow("")
    val aadhar = MutableStateFlow("")
    val address = MutableStateFlow("")
    val districtOfStudent = MutableStateFlow("")
    val mandalOfStudent = MutableStateFlow("")
    val pincodeOfStudent = MutableStateFlow("")
    val villageOfStudent = MutableStateFlow("")
    val gender = MutableStateFlow("")
    val tenthBoard = MutableStateFlow("")
    val yearOfPass = MutableStateFlow("")
    val regularOrSupply = MutableStateFlow("")
    val sscHallTicket = MutableStateFlow("")
    val districtOfInstitute = MutableStateFlow("")
    val mandalOfInstitute = MutableStateFlow("")
    val instituteAddress = MutableStateFlow("")
    val instituteName = MutableStateFlow("")
    val courseName = MutableStateFlow("")
    val admissionNumber = MutableStateFlow("")

    fun updateFullName(newFullName: String) {
        fullName.value = newFullName
    }

    fun updateGuardian(newGuardian: String) {
        guardian.value = newGuardian
    }

    fun updateDateOfBirth(newDateOfBirth: String) {
        dateOfBirth.value = newDateOfBirth
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

    fun updateAddress(newAddress: String) {
        address.value = newAddress
    }

    fun updateDistrictOfStudent(newDistrictOfStudent: String) {
        districtOfStudent.value = newDistrictOfStudent
    }

    fun updateMandalOfStudent(newMandalOfStudent: String) {
        mandalOfStudent.value = newMandalOfStudent
    }

    fun updatePincodeOfStudent(newPincodeOfStudent: String) {
        pincodeOfStudent.value = newPincodeOfStudent
    }

    fun updateVillageOfStudent(newVillageOfStudent: String) {
        villageOfStudent.value = newVillageOfStudent
    }

    fun updateGender(newGender: String) {
        gender.value = newGender
    }

    fun updateTenthBoard(newTenthBoard: String) {
        tenthBoard.value = newTenthBoard
    }

    fun updateYearOfPass(newYearOfPass: String) {
        yearOfPass.value = newYearOfPass
    }

    fun updateRegularOrSupply(newRegularOrSupply: String) {
        regularOrSupply.value = newRegularOrSupply
    }

    fun updateSscHallTicket(newSscHallTicket: String) {
        sscHallTicket.value = newSscHallTicket
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

    fun onSubmit(){
        //TODO
    }
}