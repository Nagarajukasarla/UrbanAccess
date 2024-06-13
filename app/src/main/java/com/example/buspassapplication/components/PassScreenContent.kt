package com.example.buspassapplication.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.buspassapplication.R
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.Roboto

@Composable
fun PassScreenContent(
    navController: NavHostController,
    currentUserId: String?
) {

    val generalResourceId = R.drawable.person
    val metroResourceId = R.drawable.metro
    val studentResourceId = R.drawable.student
    val routeResourceId = R.drawable.route

    Log.d("PassScreen", "${currentUserId}")

    Column(
        modifier = Modifier.padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeadingText(
                value = "My Pass", isSmall = false
            )
            Row(
                modifier = Modifier
                    .width(115.dp)
                    .height(40.dp)
                    .border(width = 1.dp, color = NavyBlue, shape = RoundedCornerShape(50))
                    .clickable {
                        navController.navigate(route = PassScreenRoutes.TicketStatus.route) { }
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                NormalText(
                    modifier = Modifier.padding(end = 3.dp),
                    value = "Processing",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Roboto,
                    color = NavyBlue
                )
                Counter(text = "2")
            }
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
