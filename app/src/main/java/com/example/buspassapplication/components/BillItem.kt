package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp

@Composable
fun BillItem(
    name: String,
    price: String,
    modifier: Modifier,
){
    Box{
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(48.toResponsiveDp())
                .fillMaxWidth()
                .background(color = Color.White)
        ){
        NormalText(
            modifier = Modifier,
            value = name,
            fontSize = 16.toResponsiveSp(),
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsMedium,
            color = DarkGray
        )
        NormalText(
            modifier = Modifier,
            value = price,
            fontSize = 16.toResponsiveSp(),
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsMedium,
            color = DarkGray
        )
        }
    }
}
