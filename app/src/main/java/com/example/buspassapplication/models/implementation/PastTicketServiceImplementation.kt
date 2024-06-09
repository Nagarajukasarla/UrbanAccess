package com.example.buspassapplication.models.implementation

import android.util.Log
import com.example.buspassapplication.data.Ticket
import com.example.buspassapplication.data.Transaction
import com.example.buspassapplication.models.service.PastTicketService
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PastTicketServiceImplementation @Inject constructor() : PastTicketService {

    private val database: DatabaseReference = FirebaseDatabase.getInstance("https://bus-pass-f61f4-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("tickets")
    override suspend fun fetchAllTickets(userId: String): List<Ticket> {
        val tickets: MutableList<Ticket> = mutableListOf()
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataSnapshot.children.forEach { ticketSnapshot ->
                    val ticket = ticketSnapshot.getValue(Ticket::class.java)
                    ticket?.let {
                        tickets.add(it)
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("PastTicketServiceImplementation","Error fetching transactions: ${databaseError.message}")
            }
        })
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
        }
        return tickets
    }

    override suspend fun fetchAllTicket(userId: String): Ticket {
        TODO("Not yet implemented")
    }
}
