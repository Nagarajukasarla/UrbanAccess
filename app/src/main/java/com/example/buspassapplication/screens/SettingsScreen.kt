package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.CardWithIcon
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.routes.BottomBarRoutes
import com.example.buspassapplication.routes.MapBarRoutes
import com.example.buspassapplication.routes.SettingScreenRoutes
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.OpenSansCondensedRegular
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.CloudGray
import toResponsiveDp
import toResponsiveSp
@Composable
fun SettingsScreen(
    navController: NavHostController,
    currentUserId: String?
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.toResponsiveDp()
    val screenWidthInPixels = with(LocalDensity.current) { screenWidth.toPx() }
    val paddingStart = (screenWidthInPixels * 0.03).toResponsiveDp()
    val paddingEnd = (screenWidthInPixels * 0.03).toResponsiveDp()

    val leftArrow = R.drawable.arrow_left
    val account = R.drawable.account
    val theme = R.drawable.eye
    val travelingGps = R.drawable.travaling_gps
    val paymentOptions = R.drawable.payment_rupee
    val reportBug = R.drawable.report_bug

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
        NormalText(
            modifier = Modifier.padding(start = 35.toResponsiveDp(), top = 15.toResponsiveDp()),
            value = "Settings",
            fontSize = 30.toResponsiveSp(),
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsBold,
            color = DarkGray
        )
        Spacer(modifier = Modifier.size(22.toResponsiveDp()))
        Divider(
            modifier = Modifier
                .height(1.toResponsiveDp())
                .padding(start = paddingStart, end = paddingEnd),
            color = CloudGray
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.toResponsiveDp()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CardWithIcon(
                    width = 330.toResponsiveDp(),
                    height = 50.toResponsiveDp(),
                    titleSize = 15.toResponsiveSp(),
                    titlesColumnWidth = 180.toResponsiveDp(),
                    title = "ACCOUNT",
                    icon = account,
                    trailingIconSize = 25.toResponsiveDp(),
                    leadingIconSize = 17.toResponsiveDp(),
                    roundedButton = false,
                    isBordered = false,
                    underLine = true,
                    onClick = {
                        navController.navigate(route = SettingScreenRoutes.Account.route){}
                    },
                )
            }
            item {
                CardWithIcon(
                    width = 330.toResponsiveDp(),
                    height = 50.toResponsiveDp(),
                    titleSize = 15.toResponsiveSp(),
                    titlesColumnWidth = 180.toResponsiveDp(),
                    title = "APPEARANCE",
                    icon = theme,
                    trailingIconSize = 25.toResponsiveDp(),
                    leadingIconSize = 17.toResponsiveDp(),
                    roundedButton = false,
                    isBordered = false,
                    underLine = true,
                    onClick = {
                        navController.navigate(route = MapBarRoutes.ComingSoonScreen.route) { }
                    },
                )
            }
            item {
                CardWithIcon(
                    width = 330.toResponsiveDp(),
                    height = 50.toResponsiveDp(),
                    titleSize = 15.toResponsiveSp(),
                    titlesColumnWidth = 180.toResponsiveDp(),
                    title = "TRAVELING GPS",
                    icon = travelingGps,
                    trailingIconSize = 25.toResponsiveDp(),
                    leadingIconSize = 17.toResponsiveDp(),
                    roundedButton = false,
                    isBordered = false,
                    underLine = true,
                    onClick = {
                        navController.navigate(route = SettingScreenRoutes.Gps.route){}
                    },
                )
            }
            item {
                CardWithIcon(
                    width = 330.toResponsiveDp(),
                    height = 50.toResponsiveDp(),
                    titleSize = 15.toResponsiveSp(),
                    titlesColumnWidth = 180.toResponsiveDp(),
                    title = "PAYMENT OPTIONS",
                    icon = paymentOptions,
                    trailingIconSize = 25.toResponsiveDp(),
                    leadingIconSize = 17.toResponsiveDp(),
                    roundedButton = false,
                    isBordered = false,
                    underLine = true,
                    onClick = {
                        navController.navigate(route = SettingScreenRoutes.Payment.route){}
                    },
                )
            }
            item {
                CardWithIcon(
                    width = 330.toResponsiveDp(),
                    height = 50.toResponsiveDp(),
                    titleSize = 15.toResponsiveSp(),
                    titlesColumnWidth = 180.toResponsiveDp(),
                    title = "REPORT BUG",
                    icon = reportBug,
                    trailingIconSize = 25.toResponsiveDp(),
                    leadingIconSize = 17.toResponsiveDp(),
                    roundedButton = false,
                    isBordered = false,
                    underLine = true,
                    onClick = {
                        navController.navigate(route = MapBarRoutes.ComingSoonScreen.route) { }
                    },
                )
            }
            item {
                NormalText(
                    modifier = Modifier.padding(top = 20.toResponsiveDp()),
                    value = "Version 0.0.0.1",
                    fontSize = 14.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = OpenSansCondensedRegular,
                    color = DimGray,
                    letterSpacing = 0.5.toResponsiveSp()
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 720)
@Composable
fun DefaultSettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController(), currentUserId = "1")
}
