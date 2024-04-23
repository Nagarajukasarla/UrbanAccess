package com.example.buspassapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R

@Composable
fun CircleWithImage() {
    Image(
        modifier=Modifier
            .size(100.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.test3),
        contentDescription = "Photo"
    )
}


@Composable
@Preview
fun PreviewCircular(){
    CircleWithImage()
}