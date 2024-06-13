package com.example.buspassapplication.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.buspassapplication.routes.TopBarRoutes
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
    Box {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Image(
                modifier = Modifier.size(43.dp).padding(start = 5.dp),
                painter = painterResource(id = R.drawable.img),
                contentDescription = "App icon"
            )
            IconButton(
                modifier = Modifier.padding(end = 5.dp),
                onClick = {
                    navController.navigate(TopBarRoutes.Settings.route) {}
                }
            ) {
                Icon(
                    painter = painterResource(id = settingsResourceId),
                    contentDescription = "Settings",
                    modifier = Modifier.size(40.dp),
                    tint = NavyBlue
                )
            }
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .align(Alignment.BottomCenter),
            color = Color.LightGray
        )
    }
}

@Preview
@Composable
fun HeaderPreview() {
    TopBar(navController = rememberNavController())
}
