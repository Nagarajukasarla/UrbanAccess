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
import toResponsiveDp
import toResponsiveSp

@Composable
fun PassContainer(
    modifier: Modifier = Modifier,
    mrnNo: String = "xxxxxxxx",
    name: String = "xxxxxxxxxxxx",
    age: String = "xx",
    gender: String = "xxxxxxxx",
    phone: String = "+91xxxxxxxxxx",
    dob: String = "xx/xx/xxxx",
    id: String = "1 2 3 4 5 6 7 8 9 0 1 2"
){
    val image = R.drawable.test3
    Column (
        modifier= Modifier
            .width(360.toResponsiveDp())
            .height(170.toResponsiveDp())
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFC0C0C0),
                        Color(0xFFDAAE3F)
                    )
                ),
                shape = RoundedCornerShape(16.toResponsiveDp())
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Box (
                modifier = Modifier.padding(top = 15.toResponsiveDp(), start = 5.toResponsiveDp())
            ) {
                CircularImage(image = image)
            }
            Spacer(modifier=Modifier.size(10.toResponsiveDp()))
            Column (
                modifier = Modifier.padding(top = 5.toResponsiveDp())
            ) {
                Spacer(modifier = Modifier.size(12.toResponsiveDp()))
                NormalText(
                    value = "MRN no: $mrnNo",
                    fontSize = 12.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.toResponsiveDp())
                )
                Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                NormalText(
                    value = "Name: $name",
                    fontSize = 12.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.toResponsiveDp())
                )
                Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                NormalText(
                    value = "Age: $age",
                    fontSize = 12.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.toResponsiveDp())
                )
                Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                NormalText(
                    value = "Gender: $gender",
                    fontSize = 12.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.toResponsiveDp())
                )
                Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                NormalText(
                    value = "Phone: +91$phone",
                    fontSize = 12.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.toResponsiveDp())
                )
                Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                NormalText(
                    value = "Date of Birth: $dob",
                    fontSize = 12.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.toResponsiveDp())
                )
                Spacer(modifier = Modifier.size(3.toResponsiveDp()))
            }
        }
        NormalText(
            value= "ID: $id",
            fontSize = 18.toResponsiveSp(),
            fontFamily = PoppinsMedium,
            color = DarkGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 6.toResponsiveDp())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPass() {
    PassContainer()
}
