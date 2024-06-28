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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Dialog
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.ShinyBlue
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@Composable
fun Popup(
    width: Dp = 300.toResponsiveDp(),
    height: Dp = 170.toResponsiveDp(),
    dismiss: Boolean = true,
    onDismissRequest: () -> Unit = {},
    onConfirmRequest: () -> Unit = {},
    title: String,
    contentOnFirstLine: String,
    contentOnSecondLine: String,
    confirmMessage: String = "Okay",
    content: @Composable () -> Unit = {}
) {
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
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically),
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
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    ),
                    value = contentOnFirstLine,
                    fontSize = 13.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray
                )
                NormalText(
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    ),
                    value = contentOnSecondLine,
                    fontSize = 13.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray
                )
                HorizontalDivider(modifier = Modifier.padding(top = 20.toResponsiveDp()))
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    if (dismiss) {
                        Row(
                            modifier = Modifier
                                .width(120.toResponsiveDp())
                                .height(40.toResponsiveDp()),
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
                                modifier = Modifier.width(115.toResponsiveDp())
                            ) {
                                NormalText(
                                    modifier = Modifier,
                                    value = "Cancel",
                                    fontSize = 13.toResponsiveSp(),
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = PoppinsBold,
                                    color = ShinyBlue
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .width(0.5.toResponsiveDp())
                                .fillMaxHeight()
                                .background(DimGray, RectangleShape)
                        )
                        Row(
                            modifier = Modifier
                                .width(120.toResponsiveDp())
                                .height(40.toResponsiveDp()),
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
                                modifier = Modifier.width(115.toResponsiveDp())
                            ) {
                                NormalText(
                                    modifier = Modifier,
                                    value = "Okay",
                                    fontSize = 13.toResponsiveSp(),
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = PoppinsBold,
                                    color = ShinyBlue
                                )
                            }
                        }
                    }
                    else {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.toResponsiveDp()),
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
                            ) {
                                NormalText(
                                    modifier = Modifier,
                                    value = confirmMessage,
                                    fontSize = 13.toResponsiveSp(),
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
        dismiss = dismiss,
        title = title,
        contentOnFirstLine = contentOnFirstLine,
        contentOnSecondLine = contentOnSecondLine
    )
}
