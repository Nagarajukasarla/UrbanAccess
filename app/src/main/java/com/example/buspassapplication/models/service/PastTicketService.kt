package com.example.buspassapplication.models.service

import com.example.buspassapplication.data.Ticket

interface PastTicketService {
    suspend fun fetchAllTickets(userId: String): List<Ticket>
    suspend fun fetchAllTicket(userId: String): Ticket
}
