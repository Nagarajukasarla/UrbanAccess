package com.example.buspassapplication.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.buspassapplication.R
import com.example.buspassapplication.data.UserPass
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.StoneWhite
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@Composable
fun PassContainer(
    modifier: Modifier = Modifier,
    pass: UserPass,
    type: String = "metro",
    imageResourceUri: Uri? = null,
    registered: Boolean = false
) {
    val image = R.drawable.unregistered

    val backgroundGradientForunRegisteredPass = Brush.linearGradient(
        colors = listOf(
            Color(0xFFE0e0e0),
            Color(0xFFE0e0e0)
        )
    )

    val backgroundGradientForGeneralPass = Brush.linearGradient(
        colors = listOf(
            Color(0xFFC0C0C0),
            Color(0xFFDAAE3F)
        )
    )

    val backgroundGradientForMetroPass = Brush.linearGradient(
        colors = listOf(
            Color(0xFF2980b9),
            Color(0xFF64b3f4),
            Color(0xFF3498db),
            Color(0xFF2c3e50)
        )
    )

    Column(
        modifier = modifier
            .width(350.toResponsiveDp())
            .height(195.toResponsiveDp())
            .background(
//                if(type == "metro") backgroundGradientForMetroPass
//                else backgroundGradientForGeneralPass
                backgroundGradientForunRegisteredPass,
                shape = RoundedCornerShape(16.toResponsiveDp())
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!registered) {
            Image(
                modifier = Modifier
                    .padding(top= 35.toResponsiveDp()),
                painter = painterResource(id = image),
                contentDescription = "Unregistered"
            )
        }
        else {
            Row {
                Box(
                    modifier = Modifier
                        .padding(start = 15.toResponsiveDp(), top = 15.toResponsiveDp())
                        .align(Alignment.CenterVertically)
                ) {
                    CircularImage(image = image)
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            start = 15.toResponsiveDp(),
                            top = 15.toResponsiveDp(),
                            end = 15.toResponsiveDp()
                        ),
                    horizontalAlignment = Alignment.Start
                ) {
                    Spacer(modifier = Modifier.size(12.toResponsiveDp()))
                    NormalText(
                        value = "MRN : ${pass.mrn}",
                        fontSize = 13.toResponsiveSp(),
                        letterSpacing = 0.5.toResponsiveSp(),
                        fontFamily = PoppinsMedium,
                        color = if (type == "metro") White else DarkGray,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.toResponsiveDp())
                    )
                    Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                    NormalText(
                        value = "Name: ${pass.name}",
                        fontSize = 12.toResponsiveSp(),
                        letterSpacing = 0.5.toResponsiveSp(),
                        fontFamily = PoppinsMedium,
                        color = if (type == "metro") White else DarkGray,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.toResponsiveDp())
                    )
                    Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                    NormalText(
                        value = "Age: $age",
                        fontSize = 12.toResponsiveSp(),
                        letterSpacing = 0.5.toResponsiveSp(),
                        fontFamily = PoppinsMedium,
                        color = if (type == "metro") White else DarkGray,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.toResponsiveDp())
                    )
                    Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                    NormalText(
                        value = "Gender: $gender",
                        fontSize = 12.toResponsiveSp(),
                        letterSpacing = 0.5.toResponsiveSp(),
                        fontFamily = PoppinsMedium,
                        color = if (type == "metro") White else DarkGray,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.toResponsiveDp())
                    )
                    Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                    NormalText(
                        value = "Phone: +91$phone",
                        fontSize = 12.toResponsiveSp(),
                        letterSpacing = 0.5.toResponsiveSp(),
                        fontFamily = PoppinsMedium,
                        color = if (type == "metro") White else DarkGray,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.toResponsiveDp())
                    )
                    Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                    NormalText(
                        value = "Date of Birth: $dob",
                        fontSize = 12.toResponsiveSp(),
                        letterSpacing = 0.5.toResponsiveSp(),
                        fontFamily = PoppinsMedium,
                        color = if (type == "metro") White else DarkGray,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.toResponsiveDp())
                    )
                    Spacer(modifier = Modifier.size(3.toResponsiveDp()))
                }
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                NormalText(
                    value = "ID: $id",
                    fontSize = 16.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = if (type == "metro") White else DarkGray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.toResponsiveDp(), bottom = 10.toResponsiveDp())
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPass() {
    PassContainer()
}
