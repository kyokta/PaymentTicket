package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.app.databinding.ActivityPaymentPageBinding

class PaymentPage : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bioskop = resources.getStringArray(R.array.bioskop)
        val seat = resources.getStringArray(R.array.seat)
        val payment = resources.getStringArray(R.array.payment_method)
        val bank = resources.getStringArray(R.array.bank)
        val jmlseat = resources.getIntArray(R.array.jmlseat)

        with(binding){
//            spinner bioskop
            val bioskopAdapter = ArrayAdapter(this@PaymentPage,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bioskop)
            bioskopAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item )
            listCinema.adapter = bioskopAdapter

//            spinner seat
            val seatAdapter = ArrayAdapter(this@PaymentPage,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, seat)
            seatAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            listSeat.adapter = seatAdapter

//            jumlah seat
            val angkaAdapter = ArrayAdapter<Int>(this@PaymentPage,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, jmlseat)
            angkaAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            sumSeat.adapter = angkaAdapter

//            datepicker
            var selectedDate = ""
            dateMovie.init (dateMovie.year, dateMovie.month, dateMovie.dayOfMonth ) {
                    _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"}

//            payment method
            val paymentAdapter = ArrayAdapter(this@PaymentPage,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, payment)
            paymentAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            paymentMethod.adapter = paymentAdapter

//            bank payment
            val bankAdapter = ArrayAdapter(this@PaymentPage,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bank)
            bankAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            bankPayment.adapter = bankAdapter
            bankPayment.isEnabled = false

//            price seat
            listSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val typeseat = seat[position]
                    val payment = when (typeseat) {
                        "Reguler Seat" -> 35000
                        "VIP" -> 45000
                        "Sleeper" -> 60000
                        else -> 0
                    }
                    priceSeat.text = payment.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Implementasikan jika tidak ada yang dipilih (opsional)
                }
            }

//            total price
//            jumlahSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                    val selectedItem = jumlah_seat[position]
//                    val priceString = priceSeat.text.toString()
//                    val harga = priceString.toIntOrNull() ?: 0
//                    val jumlah = selectedItem.toIntOrNull() ?: 0
//
//                    val totPayment = jumlah * harga
//
//                    totalPayment.text = totPayment.toString()
//                }
//
//                override fun onNothingSelected(p0: AdapterView<*>?) {
//                    TODO("Not yet implemented")
//                }
//            }

//            bank payment
            paymentMethod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedpayment = payment[position]

                    bankPayment.isEnabled = selectedpayment == "Transfer Bank"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Implementasikan jika tidak ada yang dipilih (opsional)
                }

            }
        }
    }
}