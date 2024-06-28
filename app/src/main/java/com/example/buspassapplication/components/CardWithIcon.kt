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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.example.buspassapplication.R
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.ui.theme.CloudGray
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp

@Composable
fun CardWithIcon (
    width: Dp = 350.toResponsiveDp(),
    height: Dp = 80.toResponsiveDp(),
    title: String,
    subTitle: String = "",
    titleSize: TextUnit =  16.toResponsiveSp(),
    @DrawableRes icon: Int,
    spaceAfterTrailingIcon: Dp = 37.toResponsiveDp(),
    titlesColumnWidth: Dp = 170.toResponsiveDp(),
    iconButtonSize: Dp = 30.toResponsiveDp(),
    trailingIconSize: Dp = 34.toResponsiveDp(),
    leadingIconSize: Dp = 18.toResponsiveDp(),
    roundedButton: Boolean = true,
    isBordered: Boolean = true,
    underLine: Boolean = false,
    onClick: () -> Unit,
) {

    val forwardArrowResourceId = R.drawable.arrow_forward

    val boxWithBorder = Modifier
        .height(height)
        .width(width)
        .border(
            width = 1.toResponsiveDp(),
            color = DimGray,
            shape = RoundedCornerShape(10.toResponsiveDp())
        )
        .clickable {
            onClick()
        }

    val boxWithoutBorder = Modifier
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
                letterSpacing = 0.5.toResponsiveSp()
            )
            if (!(subTitle.isEmpty() && subTitle.isEmpty())) {
                NormalText(
                    modifier = Modifier,
                    value = subTitle,
                    fontSize = 14.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsLight,
                    color = DimGray
                )
            }
        }
        Spacer(modifier = Modifier.width(10.toResponsiveDp()))

        val iconButtonStyleWithBorder = Modifier
            .border(
                width = 1.toResponsiveDp(),
                color = DimGray,
                shape = RoundedCornerShape(50.toResponsiveDp())
            )
            .size(iconButtonSize)

        val iconButtonStyleWithoutBorder = Modifier.size(iconButtonSize).padding(start = 10.toResponsiveDp())

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
            modifier = Modifier.height(1.toResponsiveDp()).width(width),
            color = CloudGray
        )
    }
}


@Preview
@Composable
fun CardWithIconPreview() {

    val generalResourceId = R.drawable.person
    CardWithIcon(
        icon = generalResourceId,
        title = "General Pass",
        subTitle = "Apply now",
        onClick = {  },
    )
}
