package com.example.buspassapplication.models.service

import com.example.buspassapplication.data.Transaction

interface TransactionService {
    suspend fun fetchAllTransactions(userId: String): List<Transaction>
    suspend fun fetchTransactionById(userId: String, transactionId: String): Transaction?
}
