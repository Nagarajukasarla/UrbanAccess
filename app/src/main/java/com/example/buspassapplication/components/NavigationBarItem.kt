package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.ui.theme.DimGray

@Composable
fun NavigationBarItem(
    @DrawableRes iconResourceId : Int
) {
    Box (
    ) {
        IconButton(
            onClick = { /*TODO*/ }
        ) {

            Icon(
                painter = painterResource(id = iconResourceId),
                contentDescription = "Visibility",
                tint = DimGray,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}