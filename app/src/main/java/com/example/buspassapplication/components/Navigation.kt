package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationBar() {
    Box(
        modifier = Modifier
            .height(43.dp)
            .width(326.dp)
            .background(color = Color(0xFF5b5d6b), shape = RoundedCornerShape(30.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationBarItem(

                label = "Notification",
                isSelected = false
            )
            NavigationBarItem(

                label = "Wallet",
                isSelected = false
            )
            NavigationBarItem(
                label = "Pass",
                isSelected = true
            )
            NavigationBarItem(
                label = "Location",
                isSelected = false
            )
            NavigationBarItem(
                label = "Profile",
                isSelected = false
            )
        }
    }
}

@Composable
fun NavigationBarItem(
    icon: Painter? = null,
    label: String,
    isSelected: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        if (icon != null) {
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = if (isSelected) Color.White else Color.Gray
        )
    }
}

@Preview
@Composable
fun Dummy(){
    NavigationBar()
}