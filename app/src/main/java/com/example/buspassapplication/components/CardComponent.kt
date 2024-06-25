package com.example.buspassapplication.components

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.CloudGray
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp

@Composable
fun CardComponent (
    width: Dp = 330.toResponsiveDp(),
    height: Dp = 60.toResponsiveDp(),
    title: String,
    titleSize: TextUnit =  25.toResponsiveSp(),
    titlesColumnWidth: Dp = 170.toResponsiveDp(),
    leadingIconSize: Dp = 21.toResponsiveDp(),
    isBordered: Boolean = true,
    underLine: Boolean = false,
    onClick: () -> Unit,
) {

    val forwardArrowResourceId = R.drawable.arrow_forward

    val boxWithBorder = Modifier
        .padding(
            top = 10.toResponsiveDp(),
            bottom = 10.toResponsiveDp()
        )
        .height(height)
        .width(width)
        .border(width = 2.toResponsiveDp(), color = DimGray, shape = RoundedCornerShape(5.toResponsiveDp()))
        .clickable {
            onClick()
        }

    val boxWithoutBorder = Modifier
        .padding(
            top = 20.toResponsiveDp(),
            bottom = 20.toResponsiveDp()
        )
        .width(width)
        .height(height)
        .clickable { onClick() }

    Row (
        modifier = if (isBordered) boxWithBorder else boxWithoutBorder,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column (
            modifier = Modifier
                .width(titlesColumnWidth)

        ) {
            NormalText(
                modifier = Modifier,
                value = title,
                fontSize = titleSize,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = DarkGray,
                letterSpacing = 0.5.toResponsiveSp()
            )
        }
        Spacer(modifier = Modifier
            .width(10.toResponsiveDp())
        )
        Icon(
            painter = painterResource(
                id = forwardArrowResourceId,
            ),
            contentDescription = "Forward arrow",
            tint = DarkGray,
            modifier = Modifier
                .size(leadingIconSize)
                .padding(end=0.toResponsiveDp())
        )
    }
    if (underLine) {
        HorizontalDivider(
            modifier = Modifier.height(1.toResponsiveDp()).width(width),
            color = CloudGray
        )
    }
}

@Preview
@Composable
fun PreviewCardComponent() {
    CardComponent(
        title = "Title",
        onClick = {}
    )
}
