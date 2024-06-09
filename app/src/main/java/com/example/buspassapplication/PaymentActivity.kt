package com.example.buspassapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.buspassapplication.data.RazorpayOrderRequest
import com.example.buspassapplication.models.utils.RazorpayOrderResponse
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class PaymentActivity : ComponentActivity(), PaymentResultWithDataListener, ExternalWalletListener {
    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(this, "Payment Successful: $p0", Toast.LENGTH_LONG).show()
        setResult(RESULT_OK)
        finish()
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Toast.makeText(this, "Payment Error: $p1", Toast.LENGTH_LONG).show()
        setResult(RESULT_CANCELED)
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
        val notes = intent.getStringExtra("notes") ?: ""
        createOrder(amount = amount, orderId = orderId, currency =  currency, notes =  JSONObject(notes))

    }

    private fun createOrder(orderId: String?, amount: Long, currency: String, notes: JSONObject?) {
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
            options.put("theme.color", "#3399cc")
            options.put("currency", currency)
            options.put("amount", amount)

            val prefill = JSONObject()
            prefill.put("email", "gaurav.kumar@example.com")
            prefill.put("contact", "9876543210")

//            val notes = JSONObject()
//            notes.put("address", "Razorpay Corporate Office")
//            notes.put("merchant_order_id", "12312321")
//            notes.put("Item", "Tea 2 cups")

            options.put("notes", notes)
            options.put("prefill", prefill)
            checkout.open(this, options)

        } catch (e: Exception) {
            Toast.makeText(this, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}