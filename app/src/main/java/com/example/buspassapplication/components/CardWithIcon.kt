package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.CloudGray
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium

@Composable
fun CardWithIcon (
    width: Dp = 320.dp,
    height: Dp = 80.dp,
    title: String,
    subTitle: String = "",
    titleSize: TextUnit =  17.sp,
    @DrawableRes icon: Int,
    spaceAfterTrailingIcon: Dp = 30.dp,
    titlesColumnWidth: Dp = 170.dp,
    iconButtonSize: Dp = 30.dp,
    trailingIconSize: Dp = 30.dp,
    leadingIconSize: Dp = 16.dp,
    roundedButton: Boolean = true,
    isBordered: Boolean = true,
    underLine: Boolean = false,
    onClick: () -> Unit,
) {

    val forwardArrowResourceId = R.drawable.arrow_forward

    val boxWithBorder = Modifier
        .padding(
            top = 20.dp,
            bottom = 20.dp
        )
        .height(height)
        .width(width)
        .border(width = 1.dp, color = DimGray, shape = RoundedCornerShape(10.dp))
        .clickable {
            onClick()
        }

    val boxWithoutBorder = Modifier
        .padding(
            top = 20.dp,
            bottom = 20.dp
        )
        .width(width)
        .height(height)
        .clickable { onClick() }

    Row (
        modifier = if (isBordered) boxWithBorder else boxWithoutBorder,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(trailingIconSize),
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
                fontSize = titleSize,
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

        val iconButtonStyleWithBorder = Modifier
            .border(
                width = 1.dp,
                color = DimGray,
                shape = RoundedCornerShape(50.dp)
            )
            .size(iconButtonSize)

        val iconButtonStyleWithoutBorder = Modifier.size(iconButtonSize).padding(start = 10.dp)

        IconButton(
            onClick = { onClick() },
            modifier = if (roundedButton) iconButtonStyleWithBorder else iconButtonStyleWithoutBorder
        ) {
            Icon(
                painter = painterResource(
                    id = forwardArrowResourceId,
                ),
                contentDescription = "Forward arrow",
                tint = DarkGray,
                modifier = Modifier.size(leadingIconSize)
            )
        }
    }
    if (underLine) {
        HorizontalDivider(
            modifier = Modifier.height(1.dp).width(width),
            color = CloudGray
        )
    }
}