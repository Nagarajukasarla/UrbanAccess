package com.example.buspassapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.BottomNavigation
import com.example.buspassapplication.components.TopBar
import com.example.buspassapplication.data.User
import com.example.buspassapplication.graphs.MainScreenNavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RestrictedApi",
    "StateFlowValueCalledInComposition", "UnrememberedMutableState"
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    currentUserId: String?,
) {



    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenHeightPixels = with (LocalDensity.current) { screenHeight.toPx() }
    val mainContentHeight = (screenHeightPixels * 0.60f).dp

    val isHidden = remember { mutableStateOf(true) }

    DisposableEffect(navController) {
        val callBack = NavController.OnDestinationChangedListener { _, _, _ ->
            val currentScreen = navController.currentDestination?.route
            isHidden.value = !(
                currentScreen == "pass" ||
                currentScreen == "wallet" ||
                currentScreen == "map" ||
                currentScreen == "profile"
            )
        }
        navController.addOnDestinationChangedListener(callBack)
        onDispose {
            navController.removeOnDestinationChangedListener(callBack)
        }
    }
    Scaffold(
        bottomBar = {
            if (!isHidden.value) BottomNavigation(navController = navController)
        },
        topBar = {
            if (!isHidden.value) TopBar(navController = navController)
        }
    ) {
        Column(
            modifier = if (!isHidden.value) Modifier.padding(top = 40.dp, bottom = 50.dp)
                       else Modifier
        ) {
            MainScreenNavigationGraph(navController = navController, currentUserId = currentUserId)
        }
    }
}