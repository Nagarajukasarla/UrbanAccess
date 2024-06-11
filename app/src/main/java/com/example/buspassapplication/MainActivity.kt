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
import com.example.buspassapplication.ui.theme.BusPassApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val viewModel: GeneralPassApplicationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusPassApplicationTheme {
                navController = rememberNavController()
                RootNavigationGraph(navController)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GeneralPassApplicationViewModel.PAYMENT_REQUEST_CODE) {
            val paymentStatus = data?.getStringExtra("paymentStatus") ?: "unknown"
            val paymentId = data?.getStringExtra("paymentId") ?: ""
            val errorCode = data?.getIntExtra("errorCode", -1) ?: -1
            val errorMessage = data?.getStringExtra("errorMessage") ?: ""
            val paymentData = data?.getStringExtra("paymentData") ?: ""
            viewModel.handlePaymentResult(paymentStatus, paymentId, errorCode, errorMessage, paymentData)
        }
    }
}