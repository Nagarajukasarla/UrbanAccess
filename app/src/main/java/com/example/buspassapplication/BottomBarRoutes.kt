package com.example.buspassapplication

sealed class BottomBarRoutes (
    val route: String,
    val title: String,
    val icon: Int
) {

    object Pass: BottomBarRoutes(
        route = "pass",
        title = "Pass",
        icon = R.drawable.pass
    )
    object Wallet: BottomBarRoutes(
        route = "wallet",
        title = "Wallet",
        icon = R.drawable.wallet
    )

    object Map: BottomBarRoutes(
        route = "map",
        title = "Map",
        icon = R.drawable.map
    )

    object Profile: BottomBarRoutes(
        route = "profile",
        title = "Profile",
        icon = R.drawable.account_circle
    )

}
