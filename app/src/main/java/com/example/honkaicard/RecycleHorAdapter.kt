package com.example.honkaicard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecycleHorAdapter(private val items: List<Relic>, var context: Context) : RecyclerView.Adapter<RecycleHorAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_list_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageId = context.resources.getIdentifier(items[position].image,
            "drawable",
            context.packageName)
        holder.image.setImageResource(imageId)

    }

    override fun getItemCount(): Int {
        return items.count()
    }
}