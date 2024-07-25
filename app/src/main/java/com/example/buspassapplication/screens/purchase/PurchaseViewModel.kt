package com.example.buspassapplication.screens.purchase

import com.example.buspassapplication.models.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(

) :AppViewModel(){
    val from = MutableStateFlow<String?>(null)
    val to = MutableStateFlow<String?>(null)

    fun updateFrom(newFrom: String) {
        from.value = newFrom
    }
    fun updateTo(newTo: String) {
        to.value = newTo
    }

    fun onSubmit(){
    }
}
