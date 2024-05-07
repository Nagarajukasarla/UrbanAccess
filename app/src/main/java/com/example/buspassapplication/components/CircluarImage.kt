package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DarkGray

@Composable
fun CircularImage(
    @DrawableRes image: Int,
    description: String = "Photo",
    size: Dp = 100.dp,
    borderWidth: Dp = 1.dp,
    borderColor: Color = DarkGray,
    borderShape: RoundedCornerShape = RoundedCornerShape(100)
) {
    Image(
        modifier=Modifier
            .size(size)
            .clip(RoundedCornerShape(100))
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            ),
        painter = painterResource(image),
        contentDescription = description
    )
}