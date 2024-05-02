package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White

@Composable
fun CardWithIcon (
    width: Dp = 325.dp,
    height: Dp = 85.dp,
    title: String,
    subTitle: String = "",
    @DrawableRes icon: Int,
    spaceAfterTrailingIcon: Dp = 30.dp,
    titlesColumnWidth: Dp = 170.dp,
    iconButtonSize: Dp = 30.dp,
    iconSize: Dp = 16.dp
) {

    val forwardArrowResourceId = R.drawable.travaling_gps

    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(8.dp),
                spotColor = DimGray,
            )
    ) {
        Row (
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 20.dp,
                    bottom = 20.dp
                ).clip(shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                painter = painterResource(id = icon),
                contentDescription = title
            )
            Spacer(modifier = Modifier.width(spaceAfterTrailingIcon))
            Column (
                modifier = Modifier.width(titlesColumnWidth),
                verticalArrangement = if (!(subTitle.isEmpty() && subTitle.isEmpty()))
                    Arrangement.Center else Arrangement.Top
            ) {
                NormalText(
                    modifier = Modifier,
                    value = title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    letterSpacing = 0.5.sp
                )
                if (!(subTitle.isEmpty() && subTitle.isEmpty())) {
                    NormalText(
                        modifier = Modifier,
                        value = subTitle,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = PoppinsLight,
                        color = DimGray
                    )
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                onClick = {},
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = DimGray,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .size(iconButtonSize)
            ) {
                Icon(
                    painter = painterResource(
                        id = forwardArrowResourceId,
                    ),
                    contentDescription = "Forward arrow",
                    tint = DarkGray,
                    modifier = Modifier.size(iconSize)
                )
            }
        }
    }
}