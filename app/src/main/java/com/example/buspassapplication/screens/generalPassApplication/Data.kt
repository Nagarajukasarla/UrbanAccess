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
    }

}