package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.app.databinding.ActivityPaymentPageBinding

class PaymentPage : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentPageBinding

    companion object {
        const val EXTRA_ID = "ext_id"
        const val EXTRA_PLACE = "ext_place"
        const val EXTRA_DATE = "ext_date"
        const val EXTRA_SEAT = "ext_seat"
        const val EXTRA_TOTSEAT = "ext_totseat"
        const val EXTRA_PRIZESEAT = "ext_prizeseat"
        const val EXTRA_PAYMET = "ext_paymet"
        const val EXTRA_TOTPAY = "ext_totpay"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(DetailsPage.EXTRA_ID)

        val bioskop = resources.getStringArray(R.array.bioskop)
        val seat = resources.getStringArray(R.array.seat)
        val payment = resources.getStringArray(R.array.payment_method)
        val bank = resources.getStringArray(R.array.bank)
//        val jmlseat = resources.getIntArray(R.array.jmlseat)
        val jmlseat = resources.getStringArray(R.array.jmlseat)

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
            val angkaAdapter = ArrayAdapter(this@PaymentPage,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, jmlseat)
            angkaAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
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
                        "Reguler" -> 35000
                        "VIP" -> 45000
                        "Sleeper" -> 60000
                        else -> 0
                    }
                    priceSeat.text = payment.toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

//            total price
            sumSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedItem = jmlseat[position]
                    val totkursi = selectedItem.split(" ")[0]
                    val priceString = priceSeat.text.toString()
                    val harga = priceString.toIntOrNull() ?: 0
                    val jumlah = totkursi.toIntOrNull() ?: 1
                    val totPayment = jumlah * harga
                    totalPayment.text = totPayment.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }

//            bank payment
            paymentMethod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selectedpayment = payment[position]
                    bankPayment.isEnabled = selectedpayment == "Transfer Bank"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

//            button order
            order.setOnClickListener{
                val selectedplace = listCinema.selectedItem.toString()
                val selectedseat = listSeat.selectedItem.toString()
                val selectedtotseat = sumSeat.selectedItem.toString()
                val prizeseat = priceSeat.text.toString()
                var selectedPaymentMethod = ""
                if (paymentMethod.selectedItem.toString() == "Transfer Bank") {
                    val selectedBank = bankPayment.selectedItem.toString()
                    selectedPaymentMethod = "Transfer Bank ($selectedBank)"
                } else {
                    selectedPaymentMethod = paymentMethod.selectedItem.toString()
                }
                val totalpayment = totalPayment.text.toString()

                val intent = Intent(this@PaymentPage, OrderSummary::class.java)
                intent.putExtra(EXTRA_ID, id)
                intent.putExtra(EXTRA_PLACE, selectedplace)
                intent.putExtra(EXTRA_DATE, selectedDate)
                intent.putExtra(EXTRA_SEAT, selectedseat)
                intent.putExtra(EXTRA_TOTSEAT, selectedtotseat)
                intent.putExtra(EXTRA_PRIZESEAT, prizeseat)
                intent.putExtra(EXTRA_PAYMET, selectedPaymentMethod)
                intent.putExtra(EXTRA_TOTPAY, totalpayment)
                startActivity(intent)
            }
        }
    }
}