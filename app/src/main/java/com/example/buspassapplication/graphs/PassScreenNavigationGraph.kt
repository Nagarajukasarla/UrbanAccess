package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.screens.generalPassApplication.GeneralPassApplicationFormScreen
import com.example.buspassapplication.screens.metroPassApplication.MetroPassApplicationFormScreen
import com.example.buspassapplication.screens.routePassApplication.RoutePassApplicationFormScreen
import com.example.buspassapplication.screens.studentPassApplication.StudentPassApplicationFormScreen


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.passScreenNavigationGraph (
    navController: NavHostController,
    currentUserId: String?
) {
    navigation(
        route = Graph.PASS,
        startDestination = PassScreenRoutes.GeneralForm.route
    ) {
        composable(route = PassScreenRoutes.GeneralForm.route) {
            GeneralPassApplicationFormScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = PassScreenRoutes.RouteForm.route) {
            RoutePassApplicationFormScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = PassScreenRoutes.MetroForm.route) {
            MetroPassApplicationFormScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = PassScreenRoutes.StudentForm.route) {
            StudentPassApplicationFormScreen(navController = navController, currentUserId = currentUserId)
        }
    }
}
