package com.example.buspassapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.graphs.RootNavigationGraph
import com.example.buspassapplication.screens.generalPassApplication.GeneralPassApplicationViewModel
import com.example.buspassapplication.ui.theme.BusPassApplicationTheme
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity(), PaymentResultWithDataListener, ExternalWalletListener {

    lateinit var navController: NavHostController
    private val viewModel: GeneralPassApplicationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //configureFirebaseServices()
        setContent {
            BusPassApplicationTheme {
                navController = rememberNavController()
                RootNavigationGraph(navController)
            }

//            Button(
//                    onClick = {
//                        initiateOrder()
//                    },
//
//                ) {
//                    Text(text = "Click me!")
//                }
        }
    }

    fun initiateOrder() {
        Checkout.preload(applicationContext)
        var checkout = Checkout()
        checkout.setKeyID("rzp_test_JmTvsyFwmcuMTd")
        try {
            val options = JSONObject()
            options.put("name", "Razorpay Corp")
            options.put("description", "Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put(
                "image",
                "https://w7.pngwing.com/pngs/93/992/png-transparent-razorpay-logo-tech-companies.png"
            )
            options.put("theme.color", "#3399cc")
            options.put("currency", "INR")
//            options.put("order_id", "order_DBJOWzybf0sJbb");
            options.put("amount", "50000")//pass amount in currency subunits

//            val retryObj = JSONObject()
//            retryObj.put("enabled", true)
//            retryObj.put("max_count", 4)
//            options.put("retry", retryObj)

            val prefill = JSONObject()
            prefill.put("email", "gaurav.kumar@example.com")
            prefill.put("contact", "9876543210")

            options.put("prefill", prefill)
            checkout.open(this, options)

        } catch (e: Exception) {
            Toast.makeText(this, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Log.d("TAG", "onPaymentError: $p1")
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }

//    private fun configureFirebaseServices() {
//        if (BuildConfig.DEBUG) {
//            Firebase.auth.useEmulator("127.0.0.1", 9099)
//            Firebase.firestore.useEmulator("127.0.0.1", 8080)
//        }
//    }
}