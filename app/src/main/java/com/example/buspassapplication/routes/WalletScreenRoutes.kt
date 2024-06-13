package com.example.buspassapplication.routes

sealed class WalletScreenRoutes(val route: String) {
    object TransactionScreen : WalletScreenRoutes(route = "transaction_history_screen")

    object PastTicketsScreen : WalletScreenRoutes(route = "past_tickets_screen")

    object TopUpScreen : WalletScreenRoutes(route = "top_up_screen")

    object PurchaseScreen : WalletScreenRoutes(route = "purchase_screen")
}
