package com.example.buspassapplication.components

import CenteredDotWithVerticalLine
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.BabyBlue
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.IceBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium

@Composable
fun DotLine(
    value: String = "",
    lineColor: Color = IceBlue,
    lineWidth: Dp = 6.dp,
    lineLength: Dp = 100.dp,
    dotRadius: Dp = 16.dp,
    modifier: Modifier = Modifier,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Bold,
    fontFamily: FontFamily = PoppinsMedium,
    color: Color = DarkGray,
    lineVisible: Boolean = true
    ) {
    Row {
        CenteredDotWithVerticalLine(
            dotRadius = dotRadius,
            lineColor = lineColor,
            lineWidth = lineWidth,
            lineLength = lineLength,
            lineVisible = lineVisible
        )
        Spacer(modifier = Modifier.width(10.dp))
        NormalText(modifier = modifier, value = value, fontSize = fontSize.sp, fontWeight = fontWeight, fontFamily = fontFamily, color = color)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DotLine(value="Secunderabad")
}
