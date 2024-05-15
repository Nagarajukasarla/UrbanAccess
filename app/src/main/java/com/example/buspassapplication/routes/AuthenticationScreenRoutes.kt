package com.example.buspassapplication.routes

sealed class AuthenticationScreenRoutes(val route: String) {
    object Login: AuthenticationScreenRoutes(route = "login_screen")
    object Signup: AuthenticationScreenRoutes(route = "signup_screen")
    object ForgotPassword: AuthenticationScreenRoutes(route = "forgot_password")
    object UpdatePassword: AuthenticationScreenRoutes(route = "update_password")
}