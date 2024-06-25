package com.example.buspassapplication.screens.pass

import com.example.buspassapplication.models.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PassContainerViewModel @Inject constructor(

) : AppViewModel() {
    val mrnNo = MutableStateFlow<String?>(null)
    val name = MutableStateFlow<String?>(null)
    val age = MutableStateFlow<String?>(null)
    val gender = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val dob = MutableStateFlow<String?>(null)
    val id = MutableStateFlow<String?>(null)

    fun updateMRN(mrn: String) {
        mrnNo.value = mrn
    }

    fun updateName(name: String) {
        this.name.value = name
    }

    fun updateAge(age: String) {
        this.age.value = age
    }

    fun updateGender(gender: String) {
        this.gender.value = gender
    }

    fun updatePhone(phone: String) {
        this.phone.value = phone
    }

    fun updateDOB(dob: String) {
        this.dob.value = dob
    }

    fun updateID(id: String) {
        this.id.value = id
    }
}
