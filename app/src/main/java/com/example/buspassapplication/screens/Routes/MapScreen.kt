package com.example.buspassapplication.screens.Routes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.DotLine
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.Popup
import com.example.buspassapplication.routes.MapBarRoutes
import com.example.buspassapplication.ui.theme.DimGray

@ExperimentalMaterial3Api
@Composable
fun MapScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: MapsViewModel = hiltViewModel()
) {
    val busNumber by viewModel.busNumber.collectAsState()
    val fromPlace by viewModel.fromPlace.collectAsState()
    val toPlace by viewModel.toPlace.collectAsState()
    var busList = mutableListOf<String>()
    var popupStatus = viewModel.showPopup.collectAsState()
    var popupTitle = viewModel.popupTitle.collectAsState()
    var contentOnFirstLine = viewModel.popupMessageOnFirstLine.collectAsState()
    var contentOnSecondLine = viewModel.popupMessageOnSecondLine.collectAsState()

    Column(
        modifier = Modifier
            .padding(bottom = 30.dp, top = 20.dp, start = 20.dp, end = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DropDown(
                label = "Bus Number",
                options = Data.busOptions,
                value = busNumber ?: "",
                onItemSelected = {
                    viewModel.updateBusNumber(it)
                },
                modifier = Modifier
            )
            IconButton(
                onClick = { navController.navigate(route = MapBarRoutes.ComingSoonScreen.route) { } },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.to_location),
                    contentDescription = null,
                    tint = DimGray,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                OutlinedInputField(
                    label = "From",
                    modifier = Modifier
                        .width(286.dp)
                        .padding(bottom = 15.dp),
                    value = fromPlace ?: "",
                    onValueChanged = {
                        viewModel.updateFrom(it)
                    }
                )
                OutlinedInputField(
                    label = "To",
                    modifier = Modifier
                        .width(286.dp)
                        .padding(bottom = 10.dp),
                    value = toPlace ?: "",
                    onValueChanged = {
                        viewModel.updateTo(it)
                    }
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding()
            ) {
                IconButton(
                    onClick = {
                        viewModel.onCheck(fromPlace?:"", toPlace?:"")
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_1),
                        contentDescription = null,
                        tint = DimGray,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }
            if (popupStatus.value) {
                Popup(
                    onDismissRequest = {
                        viewModel.updatePopupStatus(false)
                    },
                    onConfirmRequest = {
                        viewModel.updatePopupStatus(false)
                    },
                    title = popupTitle.value.ifEmpty { "Invalid Credentials" },
                    contentOnFirstLine = contentOnFirstLine.value,
                    contentOnSecondLine = contentOnSecondLine.value
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
                .verticalScroll(rememberScrollState())
                .padding(start = 40.dp)
        ) {
            val busRoute = Data.busNoRouteList[busNumber]

            if (busRoute != null) {
                busRoute.forEachIndexed { index, value ->
                    if (index < busRoute.size - 1) {
                        DotLine(
                            value = value.capitalize(),
                            dotRadius = 10.dp,
                            lineLength = 100.dp,
                            fontSize = 18
                        )
                    }
                }
                DotLine(
                    value = busRoute.last().capitalize(),
                    dotRadius = 10.dp,
                    lineLength = 100.dp,
                    fontSize = 18,
                    lineVisible = false
                )
            } else {
                println("Route not found for bus number $busNumber")
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun RoutePreview() {
    MapScreen(navController = rememberNavController(), currentUserId = null)
}
