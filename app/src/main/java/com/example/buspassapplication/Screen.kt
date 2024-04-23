package com.example.buspassapplication

sealed class Screen(val route: String) {
    object Login: Screen(route= "login_screen")
    object Signup: Screen(route= "signup_screen")
    object Pass: Screen(route = "pass_screen")
}
