package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buspassapplication.data.User
import com.example.buspassapplication.routes.BottomBarRoutes
import com.example.buspassapplication.routes.TopBarRoutes
import com.example.buspassapplication.screens.Routes.MapScreen
import com.example.buspassapplication.screens.pass.PassScreen
import com.example.buspassapplication.screens.profile.ProfileScreen
import com.example.buspassapplication.screens.SettingsScreen
import com.example.buspassapplication.screens.WalletScreen

@ExperimentalMaterial3Api
@Composable
fun MainScreenNavigationGraph (
    navController: NavHostController,
    currentUserId: String?,
    currentUser: User? = null
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarRoutes.Pass.route
    ) {
        composable(route = BottomBarRoutes.Pass.route) {
            PassScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = BottomBarRoutes.Map.route) {
            MapScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = BottomBarRoutes.Profile.route) {
            ProfileScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = BottomBarRoutes.Wallet.route) {
            WalletScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = TopBarRoutes.Settings.route) {
            SettingsScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = TopBarRoutes.Profile.route) {
            ProfileScreen(navController = navController, currentUserId = currentUserId)
        }
        passScreenNavigationGraph(navController = navController, currentUserId = currentUserId)
        walletScreenNavigationGraph(navController = navController, currentUserId = currentUserId)
        mapsScreenNavigationGraph(navController = navController, currentUserId = currentUserId)
    }
}
