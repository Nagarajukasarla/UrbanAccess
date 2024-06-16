package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@Composable
fun WalletComponent(){
    val image: Painter = painterResource(id = R.drawable.wallet_image)
    Box(
        modifier = Modifier
            .width(330.toResponsiveDp())
            .height(170.toResponsiveDp())
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalText(
                modifier = Modifier.padding(top = 20.toResponsiveDp(), start = 20.toResponsiveDp()),
                value = "First Name",
                fontSize = 28.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = White,
                letterSpacing = 0.7.toResponsiveSp()
            )
            NormalText(
                modifier = Modifier.padding(top = 5.toResponsiveDp(), start = 20.toResponsiveDp()),
                value = "Last Name",
                fontSize = 28.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = White,
                letterSpacing = 0.7.toResponsiveSp()
            )
            Spacer(modifier = Modifier.height(30.toResponsiveDp()))
            NormalText(
                modifier = Modifier.padding(start = 200.toResponsiveDp()),
                value = "₹00.000",
                fontSize = 28.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = White,
                letterSpacing = 0.7.toResponsiveSp()
            )
        }
    }
}

@Preview
@Composable
fun PreviewWalletComponent() {
    WalletComponent()
}
