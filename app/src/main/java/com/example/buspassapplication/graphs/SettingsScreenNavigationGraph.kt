package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.routes.SettingScreenRoutes
import com.example.buspassapplication.screens.AppearanceScreen
import com.example.buspassapplication.screens.Routes.MapScreen
import com.example.buspassapplication.screens.TicketStatusScreen
import com.example.buspassapplication.screens.WalletScreen
import com.example.buspassapplication.screens.generalPassApplication.GeneralPassApplicationFormScreen
import com.example.buspassapplication.screens.metroPassApplication.MetroPassApplicationFormScreen
import com.example.buspassapplication.screens.profile.ProfileScreen
import com.example.buspassapplication.screens.routePassApplication.RoutePassApplicationFormScreen
import com.example.buspassapplication.screens.studentPassApplication.StudentPassApplicationFormScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.settingsScreenNavigationGraph (
    navController: NavHostController,
    currentUserId: String?
) {
    navigation(
        route = Graph.SETTINGS,
        startDestination = SettingScreenRoutes.Account.route
    ) {
        composable(route = SettingScreenRoutes.Account.route) {
            ProfileScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = SettingScreenRoutes.Appearance.route) {
            AppearanceScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = SettingScreenRoutes.Gps.route) {
            MapScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = SettingScreenRoutes.Payment.route) {
            WalletScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = SettingScreenRoutes.ReportBug.route) {
            WalletScreen(navController = navController, currentUserId = currentUserId)
        }
    }
}
