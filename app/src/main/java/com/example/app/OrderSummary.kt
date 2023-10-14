package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityOrderSummaryBinding
import java.text.SimpleDateFormat

class OrderSummary : AppCompatActivity() {
    private lateinit var binding: ActivityOrderSummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(PaymentPage.EXTRA_ID)
        val arrayId = resources.getIdentifier(id, "array", packageName)

        val selectedplace = intent.getStringExtra(PaymentPage.EXTRA_PLACE)
        val selectedDate = intent.getStringExtra(PaymentPage.EXTRA_DATE)
        val selectedseat = intent.getStringExtra(PaymentPage.EXTRA_SEAT)
        val selectedtotseat = intent.getStringExtra(PaymentPage.EXTRA_TOTSEAT)
        val prizeseat = intent.getStringExtra(PaymentPage.EXTRA_PRIZESEAT)
        val selectedPaymentMethod = intent.getStringExtra(PaymentPage.EXTRA_PAYMET)
        val totalpayment = intent.getStringExtra(PaymentPage.EXTRA_TOTPAY)

        with(binding){
            btnBack.setOnClickListener{
                val intent = Intent(this@OrderSummary, HomePage::class.java)
                startActivity(intent)
                finish()
            }

            if (arrayId != 0) {
                val movies = resources.getStringArray(arrayId)
                titleMovie.text = movies[0]
                if (id == "movie1") {
                    imgMovie.setImageResource(R.drawable.di_ambang_kematian)
                } else if (id == "movie2") {
                    imgMovie.setImageResource(R.drawable.pamali)
                } else if (id == "movie3") {
                    imgMovie.setImageResource(R.drawable.petualangan_sherina)
                } else if (id == "movie4") {
                    imgMovie.setImageResource(R.drawable.saw_x)
                } else {
                    imgMovie.setImageResource(R.drawable.ticket)
                }
            }

            val keymov = id?.filter { it.isDigit() }
            val orderNum = keymov + selectedDate?.replace("/", "")

            placeMovie.text = selectedplace
            dateMovie.text = selectedDate
            orderNumber.text = orderNum
            seatMovie.text = selectedseat
            totalSeat.text = selectedtotseat
            prizeSeat.text = "Rp $prizeseat"
            paymentMethod.text = selectedPaymentMethod
            totalPayment.text = "Rp $totalpayment"
        }
    }
}