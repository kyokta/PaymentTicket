package com.example.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.model.Movie

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Movie>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_image)
        val title: TextView = view.findViewById(R.id.item_title)
        val duration: TextView = view.findViewById(R.id.item_duration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = context.resources.getString(item.title)
        holder.image.setImageResource(item.image)
        holder.duration.text = context.resources.getString(item.duration)
    }
}