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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.PoppinsBold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.buspassapplication.ui.theme.Black

@Composable
fun TransactionComponent(
    time: Int,
    transactionName: String,
    amount: String,
    titleSize: TextUnit =  17.sp,
    modifier: Modifier
){
    Column{
         NormalText(
             modifier = Modifier,
             value = time.toString(),
             fontSize = 12.sp,
             fontWeight = FontWeight.Bold,
             fontFamily = PoppinsBold,
             color = Color.Gray
         )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NormalText(
                modifier = Modifier,
                value = transactionName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = Black
            )
            NormalText(
                modifier = Modifier,
                value = "₹$amount",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = Black
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier,
            thickness = 2.dp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview
@Composable
fun PreviewTransactionComponent(){
    TransactionComponent(
        modifier = Modifier,
        time = 120000,
        transactionName = "TopUp",
        amount ="2",
        )
}
