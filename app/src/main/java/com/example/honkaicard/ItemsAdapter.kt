package com.example.honkaicard

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val name: TextView = view.findViewById(R.id.item_list_title)
        //val desc: TextView = view.findViewById(R.id.item_list_desc)

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
        //holder.desc.text = items[position].desc


        val imageId = context.resources.getIdentifier(items[position].image,
           "drawable",
            context.packageName)
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)

            //intent.putExtra("itemImage", items[position].image)

            // Передача уникального ключа вместо имени файла изображения
            //intent.putExtra("itemKey", items[position].id)
            //intent.putExtra("imageResourceId", R.drawable.)
            intent.putExtra("imageId", imageId)
            intent.putExtra("Ppath", items[position].path.name)


            intent.putExtra("itemTitle", items[position].name)
            intent.putExtra("itemRelics", items[position].relics)
            intent.putExtra("itemTypeOfDamage", items[position].typeOfDamage)
            intent.putExtra("itemRare", items[position].rare)
            intent.putExtra("itemDesc", items[position].desc)


            context.startActivity(intent)
        }


    }
}