package com.example.honkaicard

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val title: TextView = findViewById(R.id.charName)
        //val text: TextView = findViewById(R.id.charRare)
        val rare: TextView = findViewById(R.id.charRare)
        val desc: TextView = findViewById(R.id.desc)
        val typeOfDamage: TextView = findViewById(R.id.charTypeOfDamage)
       // val image: ImageView = findViewById(R.id.imageChar)

// Получение ключа из Intent
       // val itemKey = intent.getStringExtra("itemKey")

        // Определение изображения на основе ключа
        //val imageView: ImageView = findViewById(R.id.imageChar)
        //val imageId = resources.getIdentifier(itemKey, "drawable", packageName)
        //imageView.setImageResource(imageId)
        val imageView: ImageView = findViewById(R.id.imageChar)
        val imageId = intent.getIntExtra("imageId", 0)
        imageView.setImageResource(imageId)

        val db = DbHelper(this, null)
        val pathText: TextView = findViewById(R.id.charPath)
        val textp = db.getPath(8)

// intent.getStringExtra("Ppath") textp
        pathText.text =intent.getStringExtra("Ppath")
        title.text = intent.getStringExtra("itemTitle")
        rare.text = intent.getStringExtra("itemRare")
        desc.text = intent.getStringExtra("itemDesc")
        typeOfDamage.text = intent.getStringExtra("itemTypeOfDamage")



        val itemsListPicturesHor: RecyclerView = findViewById(R.id.recyclerView)
        val items2 = arrayListOf<Relic>()
        items2.add(Relic(1, "relic", "title"))
        items2.add(Relic(1, "relic", "title"))
        items2.add(Relic(1, "relic", "title"))
        items2.add(Relic(1, "relic", "title"))


// Устанавливаем менеджер компоновки для горизонтального расположения элементов
        itemsListPicturesHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

// Создаем адаптер, передавая список идентификаторов ресурсов изображений
        itemsListPicturesHor.adapter = RecycleHorAdapter(items2, this)

    }
}