package com.example.buspassapplication.routes

sealed class MapBarRoutes(val route: String) {
    object ComingSoonScreen : MapBarRoutes(route = "coming_soon_screen")

}
