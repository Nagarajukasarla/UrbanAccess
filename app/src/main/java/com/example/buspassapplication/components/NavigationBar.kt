package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DimGray
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.Screen
import com.example.buspassapplication.ui.theme.LightGray

@Composable
fun NavigationBar(
    navController: NavController
) {

    val homeResourceId = R.drawable.home
    val passResourceId = R.drawable.pass
    val mapResourceId = R.drawable.map
    val walletResourceId = R.drawable.wallet
    val profileResourceId = R.drawable.account_circle

    Column {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = DimGray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(color = LightGray)
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavigationBarItem(
                iconResourceId = homeResourceId,
                onClick = {
                    navController.navigate(route = Screen.ComingSoon.route) {
                        popUpTo(Screen.Pass.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
            NavigationBarItem(
                iconResourceId = walletResourceId,
                onClick = {
                    navController.navigate(route = Screen.ComingSoon.route) {
                        popUpTo(Screen.Pass.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
            NavigationBarItem(
                iconResourceId = passResourceId,
                onClick = {
                    navController.navigate(route = Screen.Pass.route) {
                        popUpTo(Screen.Pass.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
            NavigationBarItem(
                iconResourceId = mapResourceId,
                onClick = {
                    navController.navigate(route = Screen.Map.route) {
                        popUpTo(Screen.Pass.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
            NavigationBarItem(
                iconResourceId = profileResourceId,
                onClick = {
                    navController.navigate(route = Screen.ComingSoon.route) {
                        popUpTo(Screen.Pass.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun Dummy(){
    NavigationBar(navController = rememberNavController())
}