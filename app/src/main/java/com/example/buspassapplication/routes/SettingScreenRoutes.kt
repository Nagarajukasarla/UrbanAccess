package com.example.buspassapplication.routes

sealed class SettingScreenRoutes(val route: String) {
    object Account:  SettingScreenRoutes(route = "profile_screen")
    object Appearance:  SettingScreenRoutes(route = "appearance_screen")
    object Gps:  SettingScreenRoutes(route = "routes_screen")
    object Payment:  SettingScreenRoutes(route = "wallet_screen")
    object ReportBug:  SettingScreenRoutes(route = "report_screen")
}
