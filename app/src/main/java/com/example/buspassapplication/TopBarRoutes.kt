package com.example.buspassapplication

sealed class TopBarRoutes(val route: String) {
    object Settings: TopBarRoutes(route = "settings_screen")
    object Profile: TopBarRoutes(route = "profile_screen")
}