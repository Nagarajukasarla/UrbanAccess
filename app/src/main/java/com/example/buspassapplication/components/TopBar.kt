package com.example.buspassapplication.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.TopBarRoutes
import com.example.buspassapplication.ui.theme.NavyBlue

@Composable
fun TopBar(
    navController: NavHostController
) {

    val profileResourceId = R.drawable.account_circle
    val settingsResourceId = R.drawable.settings

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenWidthPixels = with(LocalDensity.current) { screenWidth.toPx() }
    val screenWidthDp = (screenWidthPixels)
    Column(

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(45.dp)
                .fillMaxWidth()
        ){
            IconButton(
                onClick = {
                    navController.navigate(TopBarRoutes.Profile.route) {}
                }
            ) {
                Icon(
                    painter = painterResource(id = profileResourceId),
                    contentDescription = "Profile",
                    modifier = Modifier.size(45.dp),
                    tint = NavyBlue
                )
            }
            Spacer(modifier = Modifier.width(3.dp))
            IconButton(
                onClick = {
                    navController.navigate(TopBarRoutes.Settings.route) {}
                }
            ) {
                Icon(
                    painter = painterResource(id = settingsResourceId),
                    contentDescription = "Settings",
                    modifier = Modifier.size(45.dp),
                    tint = NavyBlue
                )
            }
        }
        Divider (
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.LightGray
        )
    }
    
}

@Preview
@Composable
fun HeaderPreview() {
    TopBar(navController = rememberNavController())
}