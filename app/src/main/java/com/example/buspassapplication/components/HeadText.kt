package com.example.buspassapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import com.example.buspassapplication.ui.theme.TextColor

@Composable
fun HeadingText (
    value: String,
    isSmall: Boolean = false
) {
    Text(
        text = AnnotatedString(value),
        style = if(isSmall) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge,
        color = TextColor,
        textAlign = TextAlign.Center
    )
}