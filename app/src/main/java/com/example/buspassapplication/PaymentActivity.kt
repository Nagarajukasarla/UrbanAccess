package com.example.buspassapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.screens.generalPassApplication.GeneralPassApplicationViewModel
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.internal.notifyAll
import org.json.JSONObject


class PaymentActivity : ComponentActivity(), PaymentResultWithDataListener, ExternalWalletListener {

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(this, "Payment Successful: $p0", Toast.LENGTH_LONG).show()
        Log.d("PaymentActivity","Payment:  $p0")
        val data = Intent().apply {
            putExtra("paymentStatus", "success")
            putExtra("paymentId", p0)
            putExtra("paymentData", p1.toString())
        }
        setResult(RESULT_OK, data)
        finish()
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Toast.makeText(this, "Payment Error: $p1", Toast.LENGTH_LONG).show()
        val data = Intent().apply {
            putExtra("paymentStatus", "error")
            putExtra("errorCode", p0)
            putExtra("errorMessage", p1)
            putExtra("paymentData", p2.toString())
        }
        setResult(RESULT_CANCELED, data)
        finish()
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        Toast.makeText(this, "External Wallet Selected: $p0", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val amount = intent.getLongExtra("amount", 0)
        val orderId = intent.getStringExtra("orderId") ?: ""
        val currency = intent.getStringExtra("currency") ?: ""
        createOrder(amount = amount, orderId = orderId, currency =  currency)
    }

    private fun createOrder(orderId: String?, amount: Long, currency: String) {
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_JmTvsyFwmcuMTd")
        try {

            val options = JSONObject()
            options.put("name", "Razorpay Corp")
            options.put("description", "Demoing Charges")
            options.put(
                "image",
                "https://w7.pngwing.com/pngs/93/992/png-transparent-razorpay-logo-tech-companies.png"
            )
            options.put("order_id", orderId)
            options.put("theme.color", "#14589B")
            options.put("currency", currency)
            options.put("amount", amount)

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
}