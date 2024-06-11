package com.example.buspassapplication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.Roboto
import com.example.buspassapplication.ui.theme.White

@Composable
fun PaymentConfirmationPopup(
    amount: String,
    onPayRequest: () -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    val width: Dp = 310.dp
    val height: Dp = 240.dp
    val title = "Payment Confirmation"
    val contentOnFirstLine = "Your ticket will be issued"
    val contentOnSecondLine = "within 2 hours"

    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                NormalText(
                    modifier = Modifier.padding(top = 15.dp, bottom = 6.dp),
                    value = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsBold,
                    color = DarkGray
                )
                NormalText(
                    modifier = Modifier.padding(
                        top = 20.dp,
                        start = 20.dp,
                        end = 20.dp,
                    ),
                    value = contentOnFirstLine,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsLight,
                    color = DarkGray,
                    lineHeight = 10.sp
                )
                NormalText(
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
                    ),
                    value = contentOnSecondLine,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsLight,
                    color = DarkGray
                )
                Row(
                    modifier = Modifier.width(300.dp)
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier.width(110.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = NavyBlue,
                            containerColor = White
                        ),
                        border = BorderStroke(1.dp, NavyBlue),
                        onClick = {
                            onDismissRequest()
                        }
                    ) {
                        NormalText(
                            modifier = Modifier,
                            value = "Cancel",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Roboto,
                            color = NavyBlue
                        )
                    }
                    Button(
                        modifier = Modifier
                            .width(130.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = White,
                            containerColor = NavyBlue
                        ),
                        onClick = {
                            onPayRequest()
                        }
                    ) {
                        NormalText(
                            modifier = Modifier,
                            value = "Pay  ₹$amount",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Roboto,
                            color = White
                        )
                    }
                }
            }
        }
    }
}
