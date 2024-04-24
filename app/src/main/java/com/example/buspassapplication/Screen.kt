package com.example.buspassapplication

sealed class Screen(val route: String) {

    object Welcome: Screen(route = "welcome_screen")
    object Login: Screen(route= "login_screen")
    object Signup: Screen(route= "signup_screen")
    object Pass: Screen(route = "pass_screen")
    object Map: Screen(route ="map_screen")
    object ComingSoon: Screen(route = "coming_soon")
}
