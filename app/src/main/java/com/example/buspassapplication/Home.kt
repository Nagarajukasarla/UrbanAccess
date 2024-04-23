package com.example.buspassapplication

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.ui.theme.*


@Composable
fun Home() {

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(MaterialTheme.colorScheme.primary)
                ) {}
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(Color.DarkGray)
                ) {}
            }

            // Middle content (Scrollable)

            LazyColumn {
                items(5) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp)
                    ) {}
                }
            }

            // Spacer to push footer to the bottom
            Spacer(modifier = Modifier.weight(1f))

            // Footer

        }
    }
}

@Preview
@Composable
fun HomePreview () {
    Home()
}