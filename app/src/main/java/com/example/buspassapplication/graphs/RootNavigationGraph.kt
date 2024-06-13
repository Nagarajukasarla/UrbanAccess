package com.example.buspassapplication.graphs

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.buspassapplication.MainNavigation

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authenticationNavigationGraph(navController = navController)
        composable(
            route = "${Graph.MAIN}/{currentUserId}",
            arguments = listOf(navArgument("currentUserId") { type = NavType.StringType })
        ) { backStackEntry ->
            val currentUserId = backStackEntry.arguments?.getString("currentUserId")
            Log.d("RootNavigationGraph", "$currentUserId")
            MainNavigation(navController = rememberNavController(), currentUserId = currentUserId)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN = "home_graph"
    const val PASS = "pass_graph"
    const val WALLET = "wallet_graph"
    const val MAP = "map_graph"
}
