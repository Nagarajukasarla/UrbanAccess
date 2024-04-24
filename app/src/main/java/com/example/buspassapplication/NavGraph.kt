package com.example.buspassapplication

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buspassapplication.screens.LoginScreen
import com.example.buspassapplication.screens.MapScreen
import com.example.buspassapplication.screens.PassScreen
import com.example.buspassapplication.screens.SignUpScreen
import com.example.buspassapplication.screens.WelcomeScreen

@ExperimentalMaterial3Api
@Composable
fun SetupNavGraph (
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Welcome.route
    ) {
        composable(
            route= Screen.Signup.route
        ) {
            SignUpScreen(navHostController)
        }

        composable(
            route= Screen.Login.route
        ) {
            LoginScreen(navHostController)
        }
        composable(
            route = Screen.Pass.route
        ) {
            PassScreen(navController = navHostController)
        }
        composable(
            route = Screen.Welcome.route
        ) {
            WelcomeScreen(navController = navHostController)
        }

        composable(
            route = Screen.Map.route
        ) {
            MapScreen(navController = navHostController)
        }

    }
}