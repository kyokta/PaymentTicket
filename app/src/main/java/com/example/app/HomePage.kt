package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.adapter.ItemAdapter
import com.example.app.data.Datasource
import com.example.app.databinding.ActivityHomePageBinding
import com.example.app.model.Movie

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val myDataset = Datasource().loadMovies()

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.adapter = ItemAdapter(this@HomePage, myDataset)

            recyclerView.setHasFixedSize(true)
        }
    }
}