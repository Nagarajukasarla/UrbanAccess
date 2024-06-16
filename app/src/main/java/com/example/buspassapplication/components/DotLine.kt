package com.example.buspassapplication.components

import CenteredDotWithVerticalLine
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.IceBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp

@Composable
fun DotLine(
    value: String = "",
    lineColor: Color = IceBlue,
    lineWidth: Dp = 6.toResponsiveDp(),
    lineLength: Dp = 100.toResponsiveDp(),
    dotRadius: Dp = 16.toResponsiveDp(),
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
        Spacer(modifier = Modifier.width(10.toResponsiveDp()))
        NormalText(modifier = modifier, value = value, fontSize = fontSize.toResponsiveSp(), fontWeight = fontWeight, fontFamily = fontFamily, color = color)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DotLine(value="Secunderabad")
}
