package com.example.buspassapplication.samples

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

@Composable
fun CoilImage() {
    Box (
        modifier = Modifier
            .size(150.dp),
    ) {
        val painter = rememberAsyncImagePainter(
            "https://www.google.com/images/branding/googlelogo/1x/googlelogo_light_color_272x92dp.png"
        )

        if (painter.state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }

        if (painter.state is AsyncImagePainter.State.Error) {
            Log.d("LoadingSuccess", "loaded successfully")
        }

        if (painter.state is AsyncImagePainter.State.Success) {
            Image(
                painter = painter,
                contentDescription = "Andriod Developers",
                modifier = Modifier.height(50.dp).width(50.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}