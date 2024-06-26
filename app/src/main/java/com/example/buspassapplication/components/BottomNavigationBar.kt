package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.wear.compose.material.Icon
import com.example.buspassapplication.routes.BottomBarRoutes
import com.example.buspassapplication.ui.theme.IceBlue
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.ShinyBlue
import toResponsiveDp
import toResponsiveSp

@Composable
fun BottomNavigation (
    navController: NavHostController
) {
    val screens = listOf(
        BottomBarRoutes.Pass,
        BottomBarRoutes.Map,
        BottomBarRoutes.Wallet,
        BottomBarRoutes.Profile
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.toResponsiveDp()),
            color = LightGray
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 20.toResponsiveDp(), vertical = 10.toResponsiveDp())
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                screens.forEach{ screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }

    }
}

@Composable
fun RowScope.AddItem (
    screen: BottomBarRoutes,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    val selected = currentDestination?.hierarchy?.any{ it.route == screen.route } == true

    val iconBackground = if (selected) ShinyBlue.copy(alpha = 0.3f) else Color.Transparent
    val contentColor = if (selected) NavyBlue else IceBlue

    Row(
        modifier = Modifier
            .height(40.toResponsiveDp())
            .width(50.toResponsiveDp())
            .clip(RoundedCornerShape(30))
            .background(iconBackground)
            .clickable {
                if (!navController.isRouteActive(screen.route)) {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = screen.icon),
            contentDescription = "Navigation Item",
            modifier = Modifier.size(32.toResponsiveDp()),
            tint = contentColor
        )
    }
}

fun NavHostController.isRouteActive(route: String): Boolean {
    val currentRoute = this.currentBackStackEntry?.destination?.route
    return currentRoute == route
}
