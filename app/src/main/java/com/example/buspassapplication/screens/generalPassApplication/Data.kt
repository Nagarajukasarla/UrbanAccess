package com.example.buspassapplication.screens.generalPassApplication

import com.example.buspassapplication.enums.GenderEnum

class Data {

    companion object {
        val genderOptions: List<GenderEnum> = GenderEnum.entries.toList()
        val durationOptions: List<String> = listOf(
            "Weekly",
            "Monthly",
            "Quarterly",
            "Half yearly"
        )
        val divisions: List<String> = listOf(
            "MIYAPUR-04",
            "KUKATPALLY-02",
            "NIZAMPET-01",
            "BACHPALLY-03",
            "HITECH-01",
            "HITECH-04",
            "PUNJAGUTTA-02",
            "AFZALGUNG-01",
            "RAMKOTI-01",
            "KINGKOTI-00",
            "HYDERNAGAR-01"
        )
    }

}