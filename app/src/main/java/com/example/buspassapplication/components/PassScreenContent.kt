package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R

@Composable
fun PassScreenContent () {

    val generalResourceId = R.drawable.person
    val metroResourceId = R.drawable.metro
    val studentResourceId = R.drawable.student
    val routeResourceId = R.drawable.route

    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            HeadingText(
                value = "My Pass",
                isSmall = false
            )
        }
        Column (
            modifier = Modifier.padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PassComponent()
            Spacer(modifier = Modifier.height(10.dp))
            CardWithIcon (
                icon = generalResourceId,
                title = "General Pass",
                subTitle = "Apply now"
            )
            CardWithIcon(
                icon = metroResourceId,
                title = "Metro Pass",
                subTitle = "Apply now"
            )
            CardWithIcon(
                icon = studentResourceId,
                title = "Student Pass",
                subTitle = "Apply now"
            )
            CardWithIcon(
                icon = routeResourceId,
                title = "Route Pass",
                subTitle = "Apply now"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPassScreenContentPreview () {
    PassScreenContent()
}