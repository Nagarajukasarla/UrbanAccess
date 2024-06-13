package com.example.buspassapplication.screens.TransactionHistory

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.TransactionComponent
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsMedium

@Composable
fun TransactionHistoryScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: TransactionHistoryViewModel = hiltViewModel()
){

    val transactions by viewModel.transactions.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier.padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackNavigationBar(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 33.dp, top = 20.dp, end = 33.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                NormalText(
                    modifier = Modifier.padding(top = 20.dp, bottom = 0.dp, start = 0.dp),
                    value = "My Transactions",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = Black
                )
                Column {
                    transactions?.forEach{ transaction ->
                        transaction.transaction?.let {
                            transaction.dateTime?.let { it1 ->
                                TransactionComponent(
                                    time = it1.seconds,
                                    transactionName = it.value,
                                    amount = transaction.amount.toString(),
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun TransactionHistoryScreenPreview(){
//    TransactionHistoryScreen(
//        navController = navController, currentUserId = currentUserId
//    )
//}
