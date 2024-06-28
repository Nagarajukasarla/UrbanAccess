package com.example.buspassapplication.screens.pastTickets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.PastTicket
import com.example.buspassapplication.data.Ticket
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PastTicketsScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: PastTicketsViewModel = hiltViewModel()
) {
    val ticket1 = Ticket(id = "1", from = "NYC", to = "LA", dateTime = LocalDateTime.now(), img = R.drawable.test4)
    val ticket2 = Ticket(id = "2", from = "SF", to = "LV", dateTime = LocalDateTime.now(), img = R.drawable.test4)
    val ticket3 = Ticket(id = "3", from = "SEA", to = "SD", dateTime = LocalDateTime.now(), img = R.drawable.test4)

    // Create a list of Ticket objects
    val tickets1: List<Ticket>? = listOf(ticket1, ticket2, ticket3)
    val tickets by viewModel.pastTickets.collectAsState(initial = tickets1)
    Column(
        modifier = Modifier.padding(bottom = 30.toResponsiveDp()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackNavigationBar(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 33.toResponsiveDp(), top = 20.toResponsiveDp(), end = 33.toResponsiveDp())
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                NormalText(
                    modifier = Modifier.padding(
                        top = 20.toResponsiveDp(),
                        bottom = 0.toResponsiveDp(),
                        start = 10.toResponsiveDp()
                    ),
                    value = "My Past Tickets",
                    fontSize = 25.toResponsiveSp(),
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = Black
                )
                Column {
                    tickets?.forEach { ticket ->
                            ticket.dateTime?.let {
                                PastTicket(
                                    from = ticket.from.toString(),
                                    to = ticket.to.toString(),
                                    dateofPurchase = it,
                                    id = ticket.id.toString(),
                                    qrImage = ticket.img
                                )
                            }
                            Spacer(modifier = Modifier.height(10.toResponsiveDp()))
                        }
                }
            }
        }
    }
}

@Preview
@Composable
fun PastTicketsScreenPreview(){
    PastTicketsScreen(navController = rememberNavController(), currentUserId = "1")
}
