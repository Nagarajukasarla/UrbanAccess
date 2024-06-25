package com.example.buspassapplication.screens.pass

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.CardWithIcon
import com.example.buspassapplication.components.Counter
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.PassContainer
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.Roboto
import toResponsiveDp
import toResponsiveSp

@ExperimentalMaterial3Api
@Composable
fun PassScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: PassContainerViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        val generalResourceId = R.drawable.person
        val metroResourceId = R.drawable.metro
        val studentResourceId = R.drawable.student
        val routeResourceId = R.drawable.route
        val name = viewModel.name.collectAsState()
        val age = viewModel.age.collectAsState()
        val mrnNo = viewModel.mrnNo.collectAsState()
        val gender = viewModel.gender.collectAsState()
        val phone = viewModel.phone.collectAsState()
        val dob = viewModel.dob.collectAsState()
        val id = viewModel.id.collectAsState()

        Log.d("PassScreen", "$currentUserId")

        Column(
            modifier = Modifier.padding(bottom = 30.toResponsiveDp()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.toResponsiveDp(), top = 20.toResponsiveDp(), end = 20.toResponsiveDp()),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HeadingText(
                    value = "My Pass", isSmall = false
                )
                Row(
                    modifier = Modifier
                        .width(115.toResponsiveDp())
                        .height(40.toResponsiveDp())
                        .border(width = 1.toResponsiveDp(), color = NavyBlue, shape = RoundedCornerShape(50))
                        .clickable {
                            navController.navigate(route = PassScreenRoutes.TicketStatus.route) { }
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    NormalText(
                        modifier = Modifier.padding(end = 3.toResponsiveDp()),
                        value = "Processing",
                        fontSize = 15.toResponsiveSp(),
                        fontWeight = FontWeight.Bold,
                        fontFamily = Roboto,
                        color = NavyBlue
                    )
                    Counter(text = "2")
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 40.toResponsiveDp())
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PassContainer(
                    modifier = Modifier,
                    mrnNo = mrnNo.value ?:"",
                    name = name.value?:"",
                    age=age.value?:"",
                    gender=gender.value?:"",
                    phone=phone.value?:"",
                    dob=dob.value?:"",
                    id=id.value?:"",
                )
                Spacer(modifier = Modifier.height(30.toResponsiveDp()))
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
}
