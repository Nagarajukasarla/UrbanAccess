package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.ShinyBlue
import com.example.buspassapplication.ui.theme.White

@Composable
fun Popup(
    dismiss: Boolean = true,
    onDismissRequest: () -> Unit = {},
    onConfirmRequest: () -> Unit = {},
    title: String,
    contentOnFirstLine: String,
    contentOnSecondLine: String
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .width(290.dp)
                .height(170.dp)
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically),
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
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    ),
                    value = contentOnFirstLine,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray
                )
                NormalText(
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    ),
                    value = contentOnSecondLine,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray
                )
                HorizontalDivider(modifier = Modifier.padding(top = 20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    if (dismiss) {
                        Row(
                            modifier = Modifier
                                .width(120.dp)
                                .height(40.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { onDismissRequest() },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = White,
                                    contentColor = White,
                                    disabledContainerColor = LightGray,
                                    disabledContentColor = White,
                                ),
                                modifier = Modifier.width(115.dp)
                            ) {
                                NormalText(
                                    modifier = Modifier,
                                    value = "Cancel",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = PoppinsBold,
                                    color = ShinyBlue
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .width(0.5.dp)
                                .fillMaxHeight()
                                .background(DimGray, RectangleShape)
                        )
                        Row(
                            modifier = Modifier
                                .width(120.dp)
                                .height(40.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { onConfirmRequest() },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = White,
                                    contentColor = White,
                                    disabledContainerColor = LightGray,
                                    disabledContentColor = White,
                                ),
                                modifier = Modifier.width(115.dp)
                            ) {
                                NormalText(
                                    modifier = Modifier,
                                    value = "Okay",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = PoppinsBold,
                                    color = ShinyBlue
                                )
                            }
                        }
                    } else {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(onClick = { onDismissRequest() }) {
                                NormalText(
                                    modifier = Modifier,
                                    value = "Okay",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = PoppinsBold,
                                    color = ShinyBlue
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PopupView() {

    val title = "Password Mismatch"
    val contentOnFirstLine = "Please ensure that password"
    val contentOnSecondLine = "must match "
    val dismiss = false

    Popup(
        title = title,
        contentOnFirstLine = contentOnFirstLine,
        contentOnSecondLine = contentOnSecondLine,
        dismiss = dismiss
    )
}