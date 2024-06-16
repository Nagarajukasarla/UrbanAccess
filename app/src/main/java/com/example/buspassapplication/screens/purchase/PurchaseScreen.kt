package com.example.buspassapplication.screens.purchase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import toResponsiveDp
import toResponsiveSp

@Composable
fun PurchaseScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: PurchaseViewModel = hiltViewModel()
) {
    val from by viewModel.from.collectAsState()
    val to by viewModel.to.collectAsState()

    Column {
        BackNavigationBar(navController = navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 40.toResponsiveDp()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NormalText(
                modifier = Modifier
                    .padding(top = 15.toResponsiveDp(), bottom = 20.toResponsiveDp()),
                value = "Purchase Ticket",
                fontSize = 40.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = DarkGray
            )
            DropDown(
                label = "From",
                options = Data.fromOptions,
                value = from ?: "",
                onItemSelected = {
                    viewModel.updateFrom(it)
                }
            )
            Spacer(modifier = Modifier.height(40.toResponsiveDp()))
            DropDown(
                label = "To",
                options = Data.toOptions,
                value = to ?: "",
                onItemSelected = {
                    viewModel.updateTo(it)
                }
            )
            Spacer(modifier = Modifier.height(45.toResponsiveDp()))
            PrimaryButton(
                text = "Submit",
                width = 280.toResponsiveDp(),
                height = 45.toResponsiveDp(),
                borderShape = RoundedCornerShape(50),
                onClick = {
                    viewModel.onSubmit()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PurchaseScreenPreview() {
    PurchaseScreen(navController = rememberNavController(), currentUserId = null)
}
