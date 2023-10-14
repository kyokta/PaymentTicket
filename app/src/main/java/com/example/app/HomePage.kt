package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app.adapter.ItemAdapter
import com.example.app.data.Datasource
import com.example.app.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    companion object {
        const val EXTRA_ID = "ext_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val myDataset = Datasource().loadMovies()

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

            val adapter = ItemAdapter(this@HomePage, myDataset, object : ItemAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val clickedItem = myDataset[position]
                    val intent  = Intent(this@HomePage, DetailsPage::class.java)
                    intent.putExtra(EXTRA_ID, clickedItem.id.toString())
                    startActivity(intent)
//                    Toast.makeText(this@HomePage, "Item clicked: ${clickedItem.id}\"", Toast.LENGTH_SHORT).show()
                }
            })

            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
        }
    }
}