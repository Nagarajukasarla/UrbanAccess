package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.CardWithIcon
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.VeryLightGray

@Composable
fun SettingsScreen (
    navController: NavHostController,
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenWidthInPixels = with (LocalDensity.current) { screenWidth.toPx() }
    val paddingStart = (screenWidthInPixels * 0.03).dp
    val paddingEnd = (screenWidthInPixels * 0.03).dp

    val leftArrow = R.drawable.arrow_left
    val account = R.drawable.account
    val theme = R.drawable.eye
    val travelingGps = R.drawable.travaling_gps
    val paymentOptions = R.drawable.payment_rupee
    val reportBug = R.drawable.report_bug

    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 20.dp)
        ) {
            IconButton(
                modifier = Modifier.padding(start = 10.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(leftArrow),
                    contentDescription = "Back",
                    modifier = Modifier.size(55.dp)
                )
            }
        }
        NormalText(
            modifier = Modifier.padding(start = 35.dp, top = 15.dp),
            value = "Settings",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsBold,
            color = DarkGray
        )
        Spacer(modifier = Modifier.size(22.dp))
        Divider(
            modifier = Modifier
                .height(1.dp)
                .padding(start = paddingStart, end = paddingEnd),
            color = VeryLightGray
        )
        CardWithIcon(
            width = 350.dp,
            height = 60.dp,
            title = "ACCOUNT",
            icon = account
        )
        CardWithIcon(
            width = 350.dp,
            height = 65.dp,
            title = "APPREARANCE",
            icon = theme
        )
        CardWithIcon(
            width = 350.dp,
            height = 65.dp,
            title = "TRAVALING GPS",
            icon = travelingGps
        )
        CardWithIcon(
            width = 350.dp,
            height = 65.dp,
            title = "PAYMENT OPTIONS",
            icon = paymentOptions
        )
        CardWithIcon(
            width = 350.dp,
            height = 65.dp,
            title = "REPORT BUG",
            icon = reportBug
        )
    }
}

@Preview(showBackground = true, heightDp = 720)
@Composable
fun DefaultSettingsScreenPreview () {
    SettingsScreen(navController = rememberNavController())
}