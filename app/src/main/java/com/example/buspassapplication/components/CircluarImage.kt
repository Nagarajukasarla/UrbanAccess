package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.BabyBlue
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@Composable
fun CircularImage(
    @DrawableRes image: Int,
    description: String = "Photo",
    width: Dp = 120.toResponsiveDp(),
    height: Dp = 140.toResponsiveDp(),
    borderWidth: Dp = 1.toResponsiveDp(),
    borderColor: Color = White,
    borderShape: RoundedCornerShape = RoundedCornerShape(15)
) {
    Image(
        modifier=Modifier
            .width(width)
            .height(height)
            .clip(RoundedCornerShape(15))
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            ),
        painter = painterResource(image),
        contentDescription = description
    )
}
