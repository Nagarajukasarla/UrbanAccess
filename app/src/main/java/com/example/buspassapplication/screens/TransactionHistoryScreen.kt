package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.TransactionComponent
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsMedium

@Composable
fun TransactionHistoryScreen(){
    Column(
        modifier = Modifier.padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 33.dp, top = 20.dp, end = 33.dp)
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
                    TransactionComponent(time = "Today", transactionName = "TopUp", amount = "5", modifier = Modifier)
                }
            }
        }
    }
}

@Preview
@Composable
fun TransactionHistoryScreenPreview(){
    TransactionHistoryScreen()
}
