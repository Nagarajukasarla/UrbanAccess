package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import toResponsiveDp
import toResponsiveSp

@Composable
fun AppearanceScreen(
    navController: NavHostController,
    currentUserId: String?
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.toResponsiveDp()
    val screenWidthInPixels = with(LocalDensity.current) { screenWidth.toPx() }
    val paddingStart = (screenWidthInPixels * 0.03).toResponsiveDp()
    val paddingEnd = (screenWidthInPixels * 0.03).toResponsiveDp()

    val leftArrow = R.drawable.arrow_left

    val theme = R.drawable.eye

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.toResponsiveDp(), top = 20.toResponsiveDp())
        ) {
            IconButton(
                modifier = Modifier.padding(start = 10.toResponsiveDp()),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(leftArrow),
                    contentDescription = "Back",
                    modifier = Modifier.size(55.toResponsiveDp())
                )
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            NormalText(
                modifier = Modifier.padding(start = 35.toResponsiveDp(), top = 15.toResponsiveDp()),
                value = "Appearance",
                fontSize = 30.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = DarkGray
            )
            Icon(
                painter = painterResource(theme),
                contentDescription = "Appearance",
                modifier = Modifier.size(55.toResponsiveDp())
            )
        }
    }
}
