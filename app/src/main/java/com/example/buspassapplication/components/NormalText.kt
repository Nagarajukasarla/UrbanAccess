package com.example.buspassapplication.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NormalText (
    modifier: Modifier,
    value: String,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    fontFamily: FontFamily,
    color: Color,
    letterSpacing: TextUnit = 0.4.sp,
    lineHeight: TextUnit = 20.sp
) {
    Text(
        modifier = modifier,
        text = AnnotatedString(value),
        style = TextStyle(
            letterSpacing = letterSpacing,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            color = color,
            fontSize = fontSize
        ),
        lineHeight = lineHeight
    )
}