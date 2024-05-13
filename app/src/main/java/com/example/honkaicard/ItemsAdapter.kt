package com.example.honkaicard

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Character>, var context: Context) :
    RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val icon: ImageView = view.findViewById(R.id.imageViewHe)
        val name: TextView = view.findViewById(R.id.item_list_title)
        val btn: Button = view.findViewById(R.id.item_list_button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = items[position].name
       // var itemId = items[position].id


        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)


        // обновляем состояние кнопки в зависимости от значения поля fav
        items[position].fav = DbHelper(context, null).getLike(items[position].id)

        holder.icon.setOnClickListener {

            DbHelper(context, null).setLike(items[position].id)
            notifyItemChanged(position)


        }
        if (items[position].fav == 1) {
            val iconId = context.resources.getIdentifier(
                "heart",
                "drawable",
                context.packageName
            )
            holder.icon.setImageResource(iconId)


        } else {
            val iconId = context.resources.getIdentifier(
                "heart_empty",
                "drawable",
                context.packageName
            )
            holder.icon.setImageResource(iconId)
        }



        holder.btn.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)
            intent.putExtra("imageId", imageId)
            intent.putExtra("Ppath", items[position].path)
            intent.putExtra("itemId", items[position].id)
            Log.d("MyItemAdapter", "items[position].id $items[position].id")
            intent.putExtra("itemTitle", items[position].name)
            intent.putExtra("itemRelics", items[position].relics)
            intent.putExtra("itemTypeOfDamage", items[position].typeOfDamage)
            intent.putExtra("itemRare", items[position].rare)
            intent.putExtra("itemDesc", items[position].desc)

            context.startActivity(intent)
        }


    }
}