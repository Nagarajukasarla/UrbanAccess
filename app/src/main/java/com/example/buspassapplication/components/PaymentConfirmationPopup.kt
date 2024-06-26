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
import toResponsiveDp
import toResponsiveSp

@Composable
fun PaymentConfirmationPopup(
    amount: String,
    onPayRequest: () -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {
    val width: Dp = 310.toResponsiveDp()
    val height: Dp = 240.toResponsiveDp()
    val title = "Payment Confirmation"
    val contentOnFirstLine = "Your ticket will be issued"
    val contentOnSecondLine = "within 2 hours"

    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .padding(16.toResponsiveDp())
                .background(Color.White, shape = RoundedCornerShape(16.toResponsiveDp()))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                NormalText(
                    modifier = Modifier.padding(top = 15.toResponsiveDp(), bottom = 6.toResponsiveDp()),
                    value = title,
                    fontSize = 15.toResponsiveSp(),
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsBold,
                    color = DarkGray
                )
                NormalText(
                    modifier = Modifier.padding(
                        top = 20.toResponsiveDp(),
                        start = 20.toResponsiveDp(),
                        end = 20.toResponsiveDp(),
                    ),
                    value = contentOnFirstLine,
                    fontSize = 13.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsLight,
                    color = DarkGray,
                    lineHeight = 10.toResponsiveSp()
                )
                NormalText(
                    modifier = Modifier.padding(
                        start = 20.toResponsiveDp(),
                        end = 20.toResponsiveDp(),
                        bottom = 20.toResponsiveDp()
                    ),
                    value = contentOnSecondLine,
                    fontSize = 13.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsLight,
                    color = DarkGray
                )
                Row(
                    modifier = Modifier.width(300.toResponsiveDp())
                        .padding(start = 10.toResponsiveDp(), end = 10.toResponsiveDp()),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier.width(110.toResponsiveDp()),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = NavyBlue,
                            containerColor = White
                        ),
                        border = BorderStroke(1.toResponsiveDp(), NavyBlue),
                        onClick = {
                            onDismissRequest()
                        }
                    ) {
                        NormalText(
                            modifier = Modifier,
                            value = "Cancel",
                            fontSize = 15.toResponsiveSp(),
                            fontWeight = FontWeight.Bold,
                            fontFamily = Roboto,
                            color = NavyBlue
                        )
                    }
                    Button(
                        modifier = Modifier
                            .width(130.toResponsiveDp()),
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
                            fontSize = 15.toResponsiveSp(),
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
