package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

    Column (
        modifier = Modifier.padding(bottom = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, top = 20.dp)
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
            Spacer(modifier = Modifier.height(50.dp))
            CardWithIcon (
                icon = generalResourceId,
                title = "General Pass",
                subTitle = "Apply now"
            )
            Spacer(modifier = Modifier.height(20.dp))
            CardWithIcon(
                icon = metroResourceId,
                title = "Metro Pass",
                subTitle = "Apply now"
            )
            Spacer(modifier = Modifier.height(20.dp))
            CardWithIcon(
                icon = studentResourceId,
                title = "Student Pass",
                subTitle = "Apply now"
            )
            Spacer(modifier = Modifier.height(20.dp))
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