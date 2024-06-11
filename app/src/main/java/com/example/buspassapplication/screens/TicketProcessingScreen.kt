package com.example.buspassapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.Roboto

@Composable
fun TicketStatusScreen(
    navController: NavHostController,
    currentUserId: String? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BackNavigationBar(
            navController = navController,
            text = "Pending Tickets",
            fontFamily = PoppinsMedium
        )
        HorizontalDivider()
        Column {
            TicketProcessingItem()
            TicketProcessingItem()
            TicketProcessingItem()
            TicketProcessingItem()
            TicketProcessingItem()
            TicketProcessingItem()
        }
    }
}

@Composable
fun TicketProcessingItem(
    ticketId: String = "pay_uZtIjowNQ02Pwx",
    date: String = "June 10 2024",
    status: String = "Pending"
) {

    val pendingIconRes = R.drawable.pending_order

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Image(
            painter = painterResource(id = pendingIconRes),
            contentDescription = "Pending",
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .padding(start = 5.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.padding(start = 5.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            NormalText(
                modifier = Modifier.padding(bottom = 3.dp),
                value = "Ticket# $ticketId",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = Roboto,
                color = Color.DarkGray
            )
            NormalText(
                modifier = Modifier.padding(bottom = 3.dp),
                value = date,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = Roboto,
                color = Color.DarkGray
            )
            NormalText(
                modifier = Modifier,
                value = status,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = Roboto,
                color = Color.DarkGray
            )
        }
    }
    HorizontalDivider()
}