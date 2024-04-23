package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.BabyBlue
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White


@Composable
fun Pass(){

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewPass(){
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeightPixels = with (LocalDensity.current) { screenHeight.toPx() }
    val padding = (screenHeightPixels * 0.01f).dp

        Box(
            modifier= Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(width = 5.dp, color = Black, shape = RoundedCornerShape(16.dp))
                .background(Brush.linearGradient(colors=listOf(Color(0xFFC0C0C0),Color(0xFFDAAE3F))), shape = RoundedCornerShape(16.dp))
        ){
                Column{
                    Row{
                        Box(modifier=Modifier.padding(top=20.dp,start=20.dp)){
                        CircleWithImage()
                        }
                        Spacer(modifier=Modifier.size(10.dp))
                        Box(modifier=Modifier.padding(top=10.dp)){
                            Column{
                                Spacer(modifier=Modifier.size(12.dp))
                                NormalText(
                                    value= "MRN no: xxxxxxxx",
                                    fontSize = 12.sp,
                                    fontFamily = PoppinsMedium,
                                    color = DarkGray,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start=10.dp)
                                )
                                Spacer(modifier=Modifier.size(3.dp))
                                NormalText(
                                    value= "Name: xxxxxxxxxx",
                                    fontSize = 12.sp,
                                    fontFamily = PoppinsMedium,
                                    color = DarkGray,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start=10.dp)
                                )
                                Spacer(modifier=Modifier.size(3.dp))
                                NormalText(
                                    value= "Age: xx",
                                    fontSize = 12.sp,
                                    fontFamily = PoppinsMedium,
                                    color = DarkGray,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start=10.dp)
                                )
                                Spacer(modifier=Modifier.size(3.dp))
                                NormalText(
                                    value= "Gender: xxxxxx",
                                    fontSize = 12.sp,
                                    fontFamily = PoppinsMedium,
                                    color = DarkGray,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start=10.dp)
                                )
                                Spacer(modifier=Modifier.size(3.dp))
                                NormalText(
                                    value= "Phone: +91xxxxxxxxxx",
                                    fontSize = 12.sp,
                                    fontFamily = PoppinsMedium,
                                    color = DarkGray,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start=10.dp)
                                )
                                Spacer(modifier=Modifier.size(3.dp))
                                NormalText(
                                    value= "Date of Birth: xx/xx/xxxx",
                                    fontSize = 12.sp,
                                    fontFamily = PoppinsMedium,
                                    color = DarkGray,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.padding(start=10.dp)
                                )
                                Spacer(modifier=Modifier.size(3.dp))
                            }
                        }
                    }
                    Spacer(modifier=Modifier.size(20.dp))
                    NormalText(
                        value= "ID: 1 2 3 4 5 6 7 8 9 0 1 2",
                        fontSize = 20.sp,
                        fontFamily = PoppinsMedium,
                        color = DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start=30.dp)
                    )
                }
        }


}