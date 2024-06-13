package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.White

@Composable
fun WalletComponent(){
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val image: Painter = painterResource(id = R.drawable.wallet_image)
    Box(
        modifier = Modifier
            .width(330.dp)
            .height(170.dp)
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
                modifier = Modifier.padding(top = 20.dp, start = 20.dp),
                value = "First Name",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = White,
                letterSpacing = 0.7.sp
            )
            NormalText(
                modifier = Modifier.padding(top = 5.dp, start = 20.dp),
                value = "Last Name",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = White,
                letterSpacing = 0.7.sp
            )
            Spacer(modifier = Modifier.height(34.dp))
            NormalText(
                modifier = Modifier.padding(top = 5.dp, start = 200.dp),
                value = "₹00.000",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = White,
                letterSpacing = 0.7.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewWalletComponent() {
    WalletComponent()
}
