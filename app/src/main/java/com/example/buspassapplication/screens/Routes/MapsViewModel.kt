package com.example.buspassapplication.screens.Routes

import androidx.compose.runtime.collectAsState
import com.example.buspassapplication.models.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor() : AppViewModel() {
    val busNumber = MutableStateFlow<String?>(null)
    val fromPlace = MutableStateFlow<String?>(null)
    val toPlace = MutableStateFlow<String?>(null)
    val showPopup = MutableStateFlow(false)
    val popupTitle = MutableStateFlow("")
    val popupMessageOnFirstLine = MutableStateFlow("")
    val popupMessageOnSecondLine = MutableStateFlow("")

    fun updateBusNumber(newBusNumber: String) {
        busNumber.value = newBusNumber
    }

    fun updateFrom(newFrom: String) {
        fromPlace.value = newFrom
    }

    fun updateTo(newTo: String) {
        toPlace.value = newTo
    }
    fun onCheck(from: String, to: String) {
        val busNoRoute = Data.busNoRouteSet
        val busNos = mutableListOf<String>()
        val fromPlace = from.lowercase()
        val toPlace = to.lowercase()

        for ((busNo, routes) in busNoRoute) {
            if (routes.contains(fromPlace) && routes.contains(toPlace)) {
                busNos.add(busNo)
            }
        }
        if(fromPlace.isEmpty() || toPlace.isEmpty()){
            popupTitle.value = "Routes not specified"
            popupMessageOnFirstLine.value = "Please select your starting"
            popupMessageOnSecondLine.value = "and ending location."
            showPopup.value = true
        }
        else if (busNos.isNotEmpty()) {
            popupTitle.value = "Bus Routes"
            popupMessageOnFirstLine.value="The list of bus names: "
            popupMessageOnSecondLine.value = "${busNos.joinToString(", ")}"
            showPopup.value = true
        } else {
            popupTitle.value = "No Buses Found"
            popupMessageOnFirstLine.value = "No buses found"
            popupMessageOnSecondLine.value = "for the specified routes"
            showPopup.value = true
        }
    }

    fun updatePopupStatus(newStatus: Boolean) {
        showPopup.value = newStatus
    }
}
