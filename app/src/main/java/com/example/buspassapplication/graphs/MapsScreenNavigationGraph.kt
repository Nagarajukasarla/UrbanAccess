package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.MapBarRoutes
import com.example.buspassapplication.routes.WalletScreenRoutes
import com.example.buspassapplication.screens.ComingSoonScreen
import com.example.buspassapplication.screens.Purchase.PurchaseScreen
import com.example.buspassapplication.screens.TopUp.TopUpScreen
import com.example.buspassapplication.screens.pastTickets.PastTicketsScreen
import com.example.buspassapplication.screens.TransactionHistory.TransactionHistoryScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mapsScreenNavigationGraph (
    navController: NavHostController,
    currentUserId: String?
) {
    navigation(
        route = Graph.MAP,
        startDestination = MapBarRoutes.ComingSoonScreen.route
    ) {
        composable(route = MapBarRoutes.ComingSoonScreen.route){
            ComingSoonScreen(navController = navController, currentUserId = currentUserId)
        }
    }
}
