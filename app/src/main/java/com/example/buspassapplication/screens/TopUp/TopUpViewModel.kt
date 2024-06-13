package com.example.buspassapplication.screens.TopUp

import android.util.Log
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.models.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class TopUpViewModel @Inject constructor(): AppViewModel(){
    val amount = MutableStateFlow<String?>(null)
    val size = MutableStateFlow<Dp>(3.dp)
    val currAmount = MutableStateFlow<String?>("0")
    fun updateAmount(newAmount: String) {
            amount.value = newAmount
    }
    fun updateCurrentAmount(){
        currAmount.value = "0"
        TODO("Update current amount")
    }
    fun onSubmit(){
        TODO("1.Take amount from the input field")
        TODO("2.Make payment using the amount")
        TODO("3.Update the balance in top up screen and wallet screen")
    }
}
