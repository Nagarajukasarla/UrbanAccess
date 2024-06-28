package com.example.buspassapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.BlueBoxButton
import com.example.buspassapplication.components.CardComponent
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.TransactionComponent
import com.example.buspassapplication.components.WalletComponent
import com.example.buspassapplication.routes.WalletScreenRoutes
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsBold
import toResponsiveDp
import toResponsiveSp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletScreen (
    navController: NavHostController,
    currentUserId: String?
) {
    Column(
        modifier = Modifier
            .padding(bottom = 30.toResponsiveDp())
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 33.toResponsiveDp(), top = 20.toResponsiveDp(), end = 33.toResponsiveDp())
        ) {
            Column{
                HeadingText(value = "My Wallet")
                HeadingText(value = "Active", isSmall = true)
                WalletComponent()
                Spacer(modifier = Modifier.height(50.toResponsiveDp()))
                Row{
                    BlueBoxButton(
                        text = "Top up",
                        width = 100.toResponsiveDp(),
                        height = 50.toResponsiveDp(),
                        borderShape = RoundedCornerShape(10),
                        onClick = {
                            navController.navigate(route = WalletScreenRoutes.TopUpScreen.route) { }
                        }
                    )
                    Spacer(modifier = Modifier.width(130.toResponsiveDp()))
                    BlueBoxButton(
                        text = "Purchase",
                        width = 110.toResponsiveDp(),
                        height = 50.toResponsiveDp(),
                        borderShape = RoundedCornerShape(10),
                        onClick = {
                            navController.navigate(route = WalletScreenRoutes.PurchaseScreen.route) { }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(20.toResponsiveDp()))
                CardComponent(
                    title = "Past tickets",
                    onClick = {
                        navController.navigate(route = WalletScreenRoutes.PastTicketsScreen.route) { }
                    },
                )
                Spacer(modifier = Modifier.height(10.toResponsiveDp()))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    NormalText(
                        modifier = Modifier,
                        value = "Transaction history ↑↓",
                        fontSize = 16.toResponsiveSp(),
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsBold,
                        color = Black
                    )
                    Spacer(modifier = Modifier.width(20.toResponsiveDp()))
                    NormalText(
                        modifier = Modifier.clickable {
                                navController.navigate(route = WalletScreenRoutes.TransactionScreen.route) { }
                        }
                        ,
                        value = "view more",
                        fontSize = 14.toResponsiveSp(),
                        fontWeight = FontWeight.Bold,
                        fontFamily = PoppinsBold,
                        color = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(20.toResponsiveDp()))
                Column{
                    TransactionComponent(
                        time = 120000,
                        transactionName = "TopUp",
                        amount = "3",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 700)
@Composable
fun WalletScreenPreview() {
WalletScreen(navController = rememberNavController(), currentUserId = null)
}
