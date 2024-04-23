package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.Shapes

@Composable
fun CardWithIcon (
    title: String,
    subTitle: String,
    @DrawableRes icon: Int
) {

    val forwardArrowResourceId = R.drawable.arrow_forward

    Box(
        modifier = Modifier
            .width(300.dp)
            .height(100.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp),
                ambientColor = DefaultShadowColor,
                spotColor = DefaultShadowColor
            )

    ) {
        Row (
            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp),
                painter = painterResource(id = icon),
                contentDescription = title
            )
            Spacer(modifier = Modifier.width(40.dp))
            Column (
                modifier = Modifier.width(130.dp)
            ){
                HeadingText(value = title)
                NormalText(
                    modifier = Modifier,
                    value = subTitle,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsLight,
                    color = DimGray
                )
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
                    .size(35.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = forwardArrowResourceId,
                    ),
                    contentDescription = "Forward arrow",
                    tint = DarkGray,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}