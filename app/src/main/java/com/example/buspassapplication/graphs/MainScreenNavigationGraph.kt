package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buspassapplication.BottomBarRoutes
import com.example.buspassapplication.TopBarRoutes
import com.example.buspassapplication.screens.MapScreen
import com.example.buspassapplication.screens.PassScreen
import com.example.buspassapplication.screens.ProfileScreen
import com.example.buspassapplication.screens.SettingsScreen
import com.example.buspassapplication.screens.WalletScreen

@ExperimentalMaterial3Api
@Composable
fun MainScreenNavigationGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarRoutes.Pass.route
    ) {
        composable(route = BottomBarRoutes.Pass.route) {
            PassScreen(navController = navController)
        }
        composable(route = BottomBarRoutes.Map.route) {
            MapScreen(navController = navController)
        }
        composable(route = BottomBarRoutes.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = BottomBarRoutes.Wallet.route) {
            WalletScreen(navController = navController)
        }
        composable(route = TopBarRoutes.Settings.route) {
            SettingsScreen(navController = navController)
        }
        composable(route = TopBarRoutes.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}