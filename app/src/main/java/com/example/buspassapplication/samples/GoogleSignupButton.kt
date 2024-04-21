package com.example.buspassapplication.samples

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.Shapes
import com.example.buspassapplication.ui.theme.White

@ExperimentalMaterial3Api

@Composable
fun GoogleSignupButton(
    @DrawableRes drawableId: Int
) {
    var clicked by remember { mutableStateOf(false) }
    Surface(
        onClick = { clicked = !clicked },
        shape = Shapes.medium,
        border = BorderStroke(width = 2.dp, color = DimGray),
        color = White
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
        ) {
            Icon(
                painter = painterResource(id = drawableId),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Signup With Google"
            )
            Spacer(modifier = Modifier.width(8.dp))
            if (clicked) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    color = NavyBlue,
                    strokeWidth = 2.dp,
                )
            }
        }
    }
}