package com.example.buspassapplication.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.CloudGray
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.Shapes
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import com.example.buspassapplication.ui.theme.PoppinsBold
import toResponsiveDp
import toResponsiveSp

@ExperimentalMaterial3Api
@Composable
fun PastTicket(
    width: Dp = 330.toResponsiveDp(),
    height: Dp = 60.toResponsiveDp(),
    title: String,
    titleSize: TextUnit = 25.toResponsiveSp(),
    titlesColumnWidth: Dp = 170.toResponsiveDp(),
    leadingIconSize: Dp = 30.toResponsiveDp(),
    isBordered: Boolean = true,
    underLine: Boolean = false,

    ) {
    val forwardArrowResourceId = R.drawable.arrow_forward
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 270f else 90f, label = ""
    )
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing
                )
            ).border(width = 2.toResponsiveDp(), DimGray,RoundedCornerShape(5.toResponsiveDp()))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { expandedState = !expandedState },
        shape = Shapes.small,
        onClick = {
            expandedState = !expandedState
        },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.toResponsiveDp())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                NormalText(
                    modifier = Modifier.weight(6f).padding(start = 10.toResponsiveDp()),
                    value = title,
                    fontSize = titleSize,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                )
                
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = forwardArrowResourceId),
                        contentDescription = "Forward arrow",
                        tint = DarkGray,
                        modifier = Modifier
                            .size(leadingIconSize)
                            .padding(end=10.toResponsiveDp())
                            .rotate(rotationState)
                            .clickable { expandedState = !expandedState }
                    )

            }
            if (expandedState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start=10.toResponsiveDp(),end=10.toResponsiveDp()),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(){
                        NormalText(
                            modifier = Modifier,
                            value = "Date of purchase",
                            fontSize = 14.toResponsiveSp(),
                            fontWeight = FontWeight.Bold,
                            fontFamily = PoppinsBold,
                            color = DimGray,
                        )
                        Spacer(modifier = Modifier.height(3.toResponsiveDp()))
                        NormalText(
                            modifier = Modifier,
                            value = "ID",
                            fontSize = 13.toResponsiveSp(),
                            fontWeight =FontWeight.Bold,
                            fontFamily = PoppinsLight,
                            color = DarkGray,
                        )
                        Spacer(modifier = Modifier.height(5.toResponsiveDp()))
                        NormalText(
                            modifier = Modifier,
                            value = "From",
                            fontSize = 20.toResponsiveSp(),
                            fontWeight = FontWeight.Bold,
                            fontFamily = PoppinsMedium,
                            color = DarkGray,
                        )
                        Spacer(modifier = Modifier.height(5.toResponsiveDp()))
                        NormalText(
                            modifier = Modifier,
                            value = "To",
                            fontSize = 20.toResponsiveSp(),
                            fontWeight = FontWeight.Bold,
                            fontFamily = PoppinsMedium,
                            color = DarkGray,
                        )
                    }
                    Box(){
                        Image(
                            modifier=Modifier
                                .size(100.toResponsiveDp()),
                            painter = painterResource(id = R.drawable.test4),
                            contentDescription = "QR image"
                        )
                    }
                }
            }
        }}
    if (underLine) {
        HorizontalDivider(
            modifier = Modifier
                .height(1.toResponsiveDp())
                .width(width),
            color = CloudGray
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewPastTicket() {
    PastTicket(
        title = "Title"
    )
}
