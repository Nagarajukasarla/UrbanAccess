package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.WalletScreenRoutes
import com.example.buspassapplication.screens.pastTickets.PastTicketsScreen
import com.example.buspassapplication.screens.TransactionHistory.TransactionHistoryScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.walletScreenNavigationGraph (
    navController: NavHostController,
    currentUserId: String?
) {
    navigation(
        route = Graph.WALLET,
        startDestination = WalletScreenRoutes.TransactionScreen.route
    ) {
        composable(route = WalletScreenRoutes.TransactionScreen.route){
            TransactionHistoryScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = WalletScreenRoutes.PastTicketsScreen.route){
            PastTicketsScreen(navController = navController, currentUserId = currentUserId)
        }
    }
}
