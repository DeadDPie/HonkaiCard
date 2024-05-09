package com.example.honkaicard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemActivity : AppCompatActivity() {
    private var listener: OnButtonClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name: TextView = findViewById(R.id.charName)
        val rare: TextView = findViewById(R.id.charRare)
        val desc: TextView = findViewById(R.id.desc)
        val typeOfDamage: TextView = findViewById(R.id.charTypeOfDamage)
        val liked: TextView = findViewById(R.id.textViewLiked)
        val imageView: ImageView = findViewById(R.id.imageChar)
        val imageId = intent.getIntExtra("imageId", 0)
        imageView.setImageResource(imageId)

        val db = DbHelper(this, null)
        val pathText: TextView = findViewById(R.id.charPath)
        val pathId: Int = intent.getIntExtra("Ppath", 3)
        val itId = intent.getIntExtra("itemId", 3)
        val path: Path = db.getPathById(pathId)

        Log.d("MyTag", "itId $itId")
        liked.text = db.getLike(itId.toInt()).toString()

        pathText.text = path.name
        name.text = intent.getStringExtra("itemTitle")
        rare.text = intent.getStringExtra("itemRare")
        desc.text = intent.getStringExtra("itemDesc")
        typeOfDamage.text = intent.getStringExtra("itemTypeOfDamage")


        val itemsListPicturesHor: RecyclerView = findViewById(R.id.recyclerView)
        val items2 = arrayListOf<Relic>()
        items2.add(Relic(1, "relic", "title"))
        items2.add(Relic(1, "relic", "title"))
        items2.add(Relic(1, "relic", "title"))
        items2.add(Relic(1, "relic", "title"))


        itemsListPicturesHor.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        itemsListPicturesHor.adapter = RecycleHorAdapter(items2, this)

    }
}