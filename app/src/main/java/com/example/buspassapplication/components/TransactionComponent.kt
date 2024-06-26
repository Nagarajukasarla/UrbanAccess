package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.buspassapplication.ui.theme.PoppinsBold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buspassapplication.ui.theme.Black
import toResponsiveDp
import toResponsiveSp

@Composable
fun TransactionComponent(
    time: Int,
    transactionName: String,
    amount: String,

){
    Column{
         NormalText(
             modifier = Modifier,
             value = time.toString(),
             fontSize = 12.toResponsiveSp(),
             fontWeight = FontWeight.Bold,
             fontFamily = PoppinsBold,
             color = Color.Gray
         )
        Spacer(modifier = Modifier.height(5.toResponsiveDp()))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NormalText(
                modifier = Modifier,
                value = transactionName,
                fontSize = 20.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = Black
            )
            NormalText(
                modifier = Modifier,
                value = "₹$amount",
                fontSize = 20.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = Black
            )
        }
        Spacer(modifier = Modifier.height(10.toResponsiveDp()))
        Divider(
            modifier = Modifier,
            thickness = 2.toResponsiveDp(),
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.toResponsiveDp()))
    }
}

@Preview
@Composable
fun PreviewTransactionComponent(){
    TransactionComponent(
        time = 120000,
        transactionName = "TopUp",
        amount ="2",
        )
}
