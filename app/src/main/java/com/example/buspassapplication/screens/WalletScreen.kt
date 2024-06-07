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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BlueBoxButton
import com.example.buspassapplication.components.CardComponent
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.TransactionComponent
import com.example.buspassapplication.components.WalletComponent
import com.example.buspassapplication.routes.WalletScreenRoutes
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.PoppinsMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletScreen (
    navController: NavHostController,
    currentUserId: String?
) {
    Column(
        modifier = Modifier.padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 33.dp, top = 20.dp,end=33.dp)
        ) {
            Column{
                NormalText(
                    modifier = Modifier.padding(top = 20.dp, bottom = 0.dp, start = 0.dp),
                    value = "My Wallet",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = Black
                )
                NormalText(
                    modifier = Modifier.padding(top = 10.dp, bottom = 5.dp, start = 0.dp),
                    value = "Active",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = Color.Gray
                )
                WalletComponent()
                Spacer(modifier = Modifier.height(50.dp))
                Row{
                    BlueBoxButton(
                        text = "Top up",
                        width = 100.dp,
                        height = 50.dp,
                        borderShape = RoundedCornerShape(10)
                    )
                    Spacer(modifier = Modifier.width(130.dp))
                    BlueBoxButton(
                        text = "Payment",
                        width = 100.dp,
                        height = 50.dp,
                        borderShape = RoundedCornerShape(10)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                CardComponent(
                    title = "Past tickets",
                    onClick = {
                        navController.navigate(route = WalletScreenRoutes.PastTicketsScreen.route) { }
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    NormalText(
                        modifier = Modifier,
                        value = "Transaction history ↑↓",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsBold,
                        color = Black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    NormalText(
                        modifier = Modifier.clickable {
                                navController.navigate(route = WalletScreenRoutes.TransactionScreen.route) { }
                        }
                        ,
                        value = "view more",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = PoppinsBold,
                        color = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column{
                    TransactionComponent(
                        time = 120000,
                        transactionName = "TopUp",
                        amount = "3",
                        modifier = Modifier
                    )
                }
            }
        }

    }
}

//@Preview(showBackground = true, heightDp = 700)
//@Composable
//fun WalletScreenPreview() {
//    WalletScreen(navController = rememberNavController())
//}
