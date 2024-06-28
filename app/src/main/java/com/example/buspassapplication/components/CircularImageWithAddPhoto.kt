package com.example.buspassapplication.components

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.wear.compose.material.Icon
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp


@Composable
fun CircularImageWithAddPhoto(
    imageResourceUri: Uri? = null,
    onClickAddPhoto: () -> Unit = {}
) {
    val addCameraResourceId = R.drawable.add_a_photo
    Column {
        Box(
            modifier = Modifier
                .width(150.toResponsiveDp())
                .height(160.toResponsiveDp())
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(150.toResponsiveDp())
                    .clip(RoundedCornerShape(100))
                    .border(
                        width = 4.toResponsiveDp(),
                        color = NavyBlue,
                        shape = RoundedCornerShape(100)
                    ),
                model = imageResourceUri,
                contentScale = ContentScale.Crop,
                contentDescription = "profile"
            )
            IconButton(
                modifier = Modifier
                    .size(45.toResponsiveDp())
                    .align(Alignment.BottomEnd)
                    .background(color = NavyBlue, shape = CircleShape),
                onClick = {
                    onClickAddPhoto()
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(30.toResponsiveDp()),
                    painter = painterResource(id = addCameraResourceId),
                    contentDescription = "add",
                    tint = White
                )
            }
        }
    }

}
