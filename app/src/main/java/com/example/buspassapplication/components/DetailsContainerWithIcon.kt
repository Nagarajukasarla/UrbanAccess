package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Icon
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.StoneWhite
import toResponsiveDp
import toResponsiveSp

@Composable
fun DetailsContainerWithIcon (
    value: String,
    @DrawableRes icon: Int,
    width: Dp = 250.toResponsiveDp(),
    height: Dp = 40.toResponsiveDp()
) {
    Row(
        modifier = Modifier
            .width(width)
            .height(height)
            .background(color = StoneWhite, shape = RoundedCornerShape(8.toResponsiveDp()))
            .border(width = 1.toResponsiveDp(), color = LightGray, shape = RoundedCornerShape(8.toResponsiveDp())),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 10.toResponsiveDp())
                .size(26.toResponsiveDp()),
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = DimGray
        )
        NormalText(
            modifier = Modifier.padding(start = 20.toResponsiveDp(), end = 5.toResponsiveDp()),
            value = value,
            fontSize = 16.toResponsiveSp(),
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsMedium,
            color = DimGray,
            letterSpacing = 0.7.toResponsiveSp()
        )
    }
}
