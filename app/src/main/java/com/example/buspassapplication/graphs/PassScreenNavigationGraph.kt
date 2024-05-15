package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.BottomBarRoutes
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.screens.GeneralRoutePassScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphBuilder.passScreenNavigationGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.PASS,
        startDestination = PassScreenRoutes.GeneralForm.route
    ) {
        composable(route = PassScreenRoutes.GeneralForm.route) {
            GeneralRoutePassScreen(navController = navController)
        }
        composable(route = PassScreenRoutes.RouteForm.route) {
            Route
        }
    }
}