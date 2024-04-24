package com.example.buspassapplication.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun PrimaryButton(
    text: String,
    width: Dp,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = NavyBlue
        )
    ) {
        NormalText(
            value = text,
            fontSize = 17.sp,
            fontWeight = FontWeight(18),
            fontFamily = PoppinsMedium,
            color = White,
            letterSpacing = 0.5.sp,
            modifier = Modifier
        )
    }
}