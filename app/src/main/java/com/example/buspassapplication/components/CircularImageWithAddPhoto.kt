package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.White


@Composable
fun CircularImageWithAddPhoto (
    @DrawableRes imageResourceId: Int
) {
    val addCameraResourceId = R.drawable.add_a_photo

    Column {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(160.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(100))
                    .border(
                        width = 4.dp,
                        color = NavyBlue,
                        shape = RoundedCornerShape(100)
                    ),
                painter = painterResource(imageResourceId),
                contentDescription = "profile"
            )
            IconButton(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomEnd)
                    .background(color = NavyBlue, shape = CircleShape),
                onClick = {  }
            ) {
                Icon(
                    modifier = Modifier
                        .size(34.dp),
                    painter = painterResource(id = addCameraResourceId),
                    contentDescription = "add",
                    tint = White
                )
            }
        }
    }

}