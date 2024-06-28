package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Dialog
import androidx.wear.compose.material.CircularProgressIndicator
import com.example.buspassapplication.ui.theme.NavyBlue
import toResponsiveDp

@Composable
fun CircularLoaderPopup(
    width: Dp = 300.toResponsiveDp(),
    height: Dp = 200.toResponsiveDp()
) {
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = androidx.compose.ui.Modifier
                .width(width)
                .height(height)
                .padding(16.toResponsiveDp())
                .background(Color.White, shape = RoundedCornerShape(16.toResponsiveDp()))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator(indicatorColor = NavyBlue, modifier = Modifier.size(60.toResponsiveDp()))
            }
        }
    }
}

@Preview
@Composable
fun CircularLoaderPopupPreview() {
    CircularLoaderPopup()
}