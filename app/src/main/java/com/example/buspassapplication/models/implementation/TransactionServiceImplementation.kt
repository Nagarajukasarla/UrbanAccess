package com.example.buspassapplication.models.implementation

import android.util.Log
import com.example.buspassapplication.data.Transaction
import com.example.buspassapplication.models.service.TransactionService
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TransactionServiceImplementation @Inject constructor() : TransactionService {

    private val database: DatabaseReference = FirebaseDatabase.getInstance("https://bus-pass-f61f4-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("transactions")

    override suspend fun fetchAllTransactions(userId: String): List<Transaction> {
        val transactions: MutableList<Transaction> = mutableListOf()
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.children.forEach { transactionSnapshot ->
                    val transaction = transactionSnapshot.getValue(Transaction::class.java)
                    transaction?.let {
                        transactions.add(it)
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d("TransactionServiceImplementation","Error fetching transactions: ${databaseError.message}")
            }
        })


        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
        }
        return transactions
    }

    override suspend fun fetchTransactionById(userId: String, transactionId: String): Transaction? {
        var transaction: Transaction? = null


        database.child(userId).child(transactionId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                transaction = dataSnapshot.getValue(Transaction::class.java)
            }

            override fun onCancelled(databaseError: DatabaseError) {

                println("Error fetching transaction: ${databaseError.message}")
            }
        })


        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
        }

        return transaction
    }
}
