package com.example.buspassapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.graphs.RootNavigationGraph
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.screens.generalPassApplication.GeneralPassApplicationViewModel
import com.example.buspassapplication.screens.metroPassApplication.MetroPassApplicationViewModel
import com.example.buspassapplication.ui.theme.BusPassApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val generalPassApplicationViewModel: GeneralPassApplicationViewModel by viewModels()
    private val metroPassApplicationViewModel: MetroPassApplicationViewModel by viewModels()


    private val intentResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        //if (result.resultCode == GeneralPassApplicationViewModel.PAYMENT_REQUEST_CODE) {
            val paymentStatus = result.data?.getStringExtra("paymentStatus") ?: "unknown"
            val paymentId = result.data?.getStringExtra("paymentId") ?: ""
            val errorCode = result.data?.getIntExtra("errorCode", -1) ?: -1
            val errorMessage = result.data?.getStringExtra("errorMessage") ?: ""
            val paymentData = result.data?.getStringExtra("paymentData") ?: ""
            generalPassApplicationViewModel.handlePaymentResult(paymentStatus, paymentId, errorCode, errorMessage, paymentData)
        //}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusPassApplicationTheme {
                navController = rememberNavController()
                RootNavigationGraph(navController)
            }
        }
    }

    fun startPaymentActivity(orderId: String, amount: Long, currency: String) {
        val intent = Intent(this, PaymentActivity::class.java).apply {
            putExtra("orderId", orderId)
            putExtra("amount", amount)
            putExtra("currency", currency)
        }
        intentResultLauncher.launch(intent)
    }

}
