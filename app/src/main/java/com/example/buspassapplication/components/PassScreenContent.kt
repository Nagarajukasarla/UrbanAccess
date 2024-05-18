package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.routes.PassScreenRoutes

@Composable
fun PassScreenContent(
    navController: NavHostController
) {

    val generalResourceId = R.drawable.person
    val metroResourceId = R.drawable.metro
    val studentResourceId = R.drawable.student
    val routeResourceId = R.drawable.route

    Column(
        modifier = Modifier.padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, top = 20.dp)
        ) {
            HeadingText(
                value = "My Pass", isSmall = false
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PassComponent()
            Spacer(modifier = Modifier.height(30.dp))
            CardWithIcon(
                icon = generalResourceId,
                title = "General Pass",
                subTitle = "Apply now",
                onClick = {
                    navController.navigate(route = Graph.PASS) { }
                },
            )
            CardWithIcon(
                icon = metroResourceId,
                title = "Metro Pass",
                subTitle = "Apply now",
                onClick = {
                    navController.navigate(route = PassScreenRoutes.MetroForm.route) { }
                },
            )
            CardWithIcon(
                icon = studentResourceId,
                title = "Student Pass",
                subTitle = "Apply now",
                onClick = {
                    navController.navigate(route = PassScreenRoutes.StudentForm.route) { }
                },
            )
            CardWithIcon(
                icon = routeResourceId,
                title = "Route Pass",
                subTitle = "Apply now",
                onClick = {
                    navController.navigate(route = PassScreenRoutes.RouteForm.route) { }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPassScreenContentPreview() {
    PassScreenContent(navController = rememberNavController())
}