package com.example.buspassapplication.screens.pastTickets

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.R
import com.example.buspassapplication.data.Ticket
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.PastTicketService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class PastTicketsViewModel @Inject constructor(
    private val pastTicketService: PastTicketService
) : AppViewModel(){
    val ticket1 = Ticket(id = "1", from = "NYC", to = "LA", dateTime = LocalDateTime.now(), img = R.drawable.test4)
    val ticket2 = Ticket(id = "2", from = "SF", to = "LV", dateTime = LocalDateTime.now(), img = R.drawable.test4)
    val ticket3 = Ticket(id = "3", from = "SEA", to = "SD", dateTime = LocalDateTime.now(), img = R.drawable.test4)


    val tickets1: List<Ticket>? = listOf(ticket1, ticket2, ticket3)
val pastTickets = MutableStateFlow<List<Ticket>?>(null)
//    init {
//        viewModelScope.launch {
//            fetchTickets("tickets")
//        }
//    }
    suspend fun fetchTickets(userId: String) {
        try {
            val fetchedTickets = pastTicketService.fetchAllTickets(userId)
            pastTickets.value = fetchedTickets
            Log.d("TransactionHistoryViewModel","Transactions fetched: $fetchedTickets")
        } catch (e: Exception) {
            // Handle error appropriately, such as logging or displaying a message to the user
            Log.d("TransactionHistoryViewModel","Error fetching transactions: ${e.message}")
        }
    }
}
