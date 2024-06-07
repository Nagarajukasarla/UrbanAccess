package com.example.buspassapplication.screens.TransactionHistory

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.buspassapplication.data.Transaction
import com.example.buspassapplication.models.AppViewModel
import com.example.buspassapplication.models.service.TransactionService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionHistoryViewModel @Inject constructor(
    private val transactionService: TransactionService
) : AppViewModel() {

    val transactions = MutableStateFlow<List<Transaction>?>(null)

    init {
        viewModelScope.launch {
            fetchTransactions("transactions")
        }
    }

    suspend fun fetchTransactions(userId: String) {
        try {
            val fetchedTransactions = transactionService.fetchAllTransactions(userId)
            transactions.value = fetchedTransactions
            Log.d("TransactionHistoryViewModel","Transactions fetched: $fetchedTransactions")
        } catch (e: Exception) {
            // Handle error appropriately, such as logging or displaying a message to the user
            Log.d("TransactionHistoryViewModel","Error fetching transactions: ${e.message}")
        }
    }
}
