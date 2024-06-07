package com.example.buspassapplication.routes

sealed class WalletScreenRoutes(val route: String) {
    object TransactionScreen : WalletScreenRoutes(route = "transaction_history_screen")

    object PastTicketsScreen : WalletScreenRoutes(route = "past_tickets_screen")
}
