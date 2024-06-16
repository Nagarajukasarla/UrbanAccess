package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.Roboto
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@Composable
fun Counter(
    text: String
) {
    Box(
        modifier = Modifier
            .width(19.toResponsiveDp())
            .height(19.toResponsiveDp())
            .background(color = NavyBlue, shape = RoundedCornerShape(50)),
        contentAlignment = Alignment.Center
    ) {
        NormalText(
            modifier = Modifier,
            value = text, fontSize = 12.toResponsiveSp(),
            fontWeight = FontWeight.Bold,
            fontFamily = Roboto,
            color = White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    Counter(text = "2")
}



