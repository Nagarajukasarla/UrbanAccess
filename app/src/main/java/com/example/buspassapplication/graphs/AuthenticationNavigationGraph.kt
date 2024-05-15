package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.AuthenticationScreenRoutes
import com.example.buspassapplication.screens.PasswordRecoveryScreen
import com.example.buspassapplication.screens.LoginScreen
import com.example.buspassapplication.screens.SignUpScreen
import com.example.buspassapplication.screens.UpdatePasswordScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.authenticationNavigationGraph (
    navController: NavHostController
) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthenticationScreenRoutes.Login.route
    ) {
        composable(
            route = AuthenticationScreenRoutes.Login.route,
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = AuthenticationScreenRoutes.Signup.route
        ) {
            SignUpScreen(navController = navController)
        }
        composable(
            route = AuthenticationScreenRoutes.ForgotPassword.route
        ) {
            PasswordRecoveryScreen(navController = navController)
        }
        composable(
            route = AuthenticationScreenRoutes.UpdatePassword.route
        ) {
            UpdatePasswordScreen(navController = navController)
        }
    }
}