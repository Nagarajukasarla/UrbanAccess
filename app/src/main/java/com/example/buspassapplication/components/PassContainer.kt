package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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


@Composable
fun PassComponent(){
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val image = R.drawable.test3

    Column (
        modifier= Modifier
            .width(330.dp)
            .height(170.dp)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFC0C0C0),
                        Color(0xFFDAAE3F)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Box (
                modifier = Modifier.padding(top = 15.dp, start = 5.dp)
            ) {
                CircularImage(image = image)
            }
            Spacer(modifier=Modifier.size(10.dp))
            Column (
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Spacer(modifier = Modifier.size(12.dp))
                NormalText(
                    value = "MRN no: xxxxxxxx",
                    fontSize = 12.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(3.dp))
                NormalText(
                    value = "Name: xxxxxxxxxx",
                    fontSize = 12.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(3.dp))
                NormalText(
                    value = "Age: xx",
                    fontSize = 12.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(3.dp))
                NormalText(
                    value = "Gender: xxxxxx",
                    fontSize = 12.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(3.dp))
                NormalText(
                    value = "Phone: +91xxxxxxxxxx",
                    fontSize = 12.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(3.dp))
                NormalText(
                    value = "Date of Birth: xx/xx/xxxx",
                    fontSize = 12.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(3.dp))
            }
        }
        NormalText(
            value= "ID: 1 2 3 4 5 6 7 8 9 0 1 2",
            fontSize = 18.sp,
            fontFamily = PoppinsMedium,
            color = DarkGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPass() {
    PassComponent()
}
