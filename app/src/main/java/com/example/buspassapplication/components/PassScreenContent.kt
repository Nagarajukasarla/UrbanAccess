package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.Shapes

@Composable
fun PassScreenContent () {

    val generalResourceId = R.drawable.person
    val metroResourceId = R.drawable.metro
    val studentResourceId = R.drawable.student
    val routeResourceId = R.drawable.route

    Column (
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        ) {
            HeadingText(
                value = "My Pass",
                isSmall = false
            )
        }

        // Pass container

        CardWithIcon(icon = generalResourceId, title = "General Pass", subTitle = "Apply now",)
        CardWithIcon(icon = metroResourceId, title = "Metro Pass", subTitle = "Apply now")
        CardWithIcon(icon = studentResourceId, title = "Student Pass", subTitle = "Apply now")
        CardWithIcon(icon = routeResourceId, title = "Route Pass", subTitle = "Apply now")

    }
}

@Preview
@Composable
fun DefaultPassScreenContentPreview () {
    PassScreenContent()
}