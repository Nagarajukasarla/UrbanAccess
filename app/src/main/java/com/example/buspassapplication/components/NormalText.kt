package com.example.buspassapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.TextColor

@Composable
fun HeadingText (
    value: String,
    isSmall: Boolean,

) {
    Text(
        text = AnnotatedString(value),
        modifier = Modifier
            .fillMaxWidth(),
        style = if(isSmall) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge,
        color = TextColor,
        textAlign = TextAlign.Center,

    )
}

@Composable
fun NormalText (
    modifier: Modifier,
    value: AnnotatedString,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    fontFamily: FontFamily,
    color: Color,
    letterSpacing: TextUnit = 0.4.sp
) {
    Text(
        modifier = modifier,
        text = value,
        style = TextStyle(
            letterSpacing = letterSpacing,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            color = color,
            fontSize = fontSize
        )
    )
}