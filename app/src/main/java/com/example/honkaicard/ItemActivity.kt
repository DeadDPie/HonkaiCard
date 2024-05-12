package com.example.honkaicard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        //val rare: TextView = findViewById(R.id.charRare)
        val desc: TextView = findViewById(R.id.desc)
        val typeOfDamage: TextView = findViewById(R.id.charTypeOfDamage)
        //val liked: TextView = findViewById(R.id.textViewLiked)
        val imageView: ImageView = findViewById(R.id.imageChar)
        val imageId = intent.getIntExtra("imageId", 0)
        imageView.setImageResource(imageId)

        val db = DbHelper(this, null)
        val pathText: TextView = findViewById(R.id.charPath)
        val pathId: Int = intent.getIntExtra("Ppath", 3)
        val itId = intent.getIntExtra("itemId", 3)
        val path: Path = db.getPathById(pathId)
        val imagePath: ImageView = findViewById(R.id.imagePath)

        if (pathId == 1) {
            val iconId = resources.getIdentifier(
                "destruction",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }
        if (pathId == 2) {
            val iconId = resources.getIdentifier(
                "hunt",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }
        if (pathId == 3) {
            val iconId = resources.getIdentifier(
                "erudition",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }
        if (pathId == 4) {
            val iconId = resources.getIdentifier(
                "harmony",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }
        if (pathId == 5) {
            val iconId = resources.getIdentifier(
                "nihility",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }
        if (pathId == 6) {
            val iconId = resources.getIdentifier(
                "preservation",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }
        if (pathId == 7) {
            val iconId = resources.getIdentifier(
                "abudance",
                "drawable",
                packageName
            )
            imagePath.setImageResource(iconId)
        }

        imagePath.setOnClickListener{
            val pathObj = db.getPathById(pathId)
            showInfoAlert(pathObj.description)

        }
        Log.d("MyTag", "itId $itId")
        //liked.text = db.getLike(itId.toInt()).toString()

        pathText.text = path.name
        name.text = intent.getStringExtra("itemTitle")
        val rareValue  = intent.getStringExtra("itemRare")
        if (rareValue == "4") {
            val imageView5: ImageView = findViewById(R.id.imageStar5)
            imageView5.visibility = View.INVISIBLE
        }
        desc.text = intent.getStringExtra("itemDesc")
        val TypeOfDamage = intent.getStringExtra("itemTypeOfDamage")
        typeOfDamage.text = TypeOfDamage

        val imageTypeOfDamage:ImageView = findViewById(R.id.imageTypeOgDamage)
        if (TypeOfDamage == "Электрический") {
            val iconId = resources.getIdentifier(
                "electro",
                "drawable",
                packageName
            )
            imageTypeOfDamage.setImageResource(iconId)
        }
        if (TypeOfDamage == "Огненный") {
            val iconId = resources.getIdentifier(
                "fire",
                "drawable",
                packageName
            )
            imageTypeOfDamage.setImageResource(iconId)
        }
        if (TypeOfDamage == "Физический") {
            val iconId = resources.getIdentifier(
                "fiz",
                "drawable",
                packageName
            )
            imageTypeOfDamage.setImageResource(iconId)
        }
        if (TypeOfDamage == "Ледяной") {
            val iconId = resources.getIdentifier(
                "ice",
                "drawable",
                packageName
            )
            imageTypeOfDamage.setImageResource(iconId)
        }
        if (TypeOfDamage == "Квантовый") {
            val iconId = resources.getIdentifier(
                "kvant",
                "drawable",
                packageName
            )
            imageTypeOfDamage.setImageResource(iconId)
        }
        if (TypeOfDamage == "Мнимый") {
            val iconId = resources.getIdentifier(
                "mnim",
                "drawable",
                packageName
            )
            imageTypeOfDamage.setImageResource(iconId)
        }
        val relicId = intent.getStringExtra("itemRelics")!!.toInt()
        val relic: Relic? = db.getRelicById(relicId)
        val textRelic: TextView = findViewById(R.id.textRelic)
        if (relic != null) {
            textRelic.text = relic.name
        }
        val imageRelic: ImageView = findViewById(R.id.imageRelic)
        if (relic != null) {
                val iconId = resources.getIdentifier(
                    relic.image,
                    "drawable",
                    packageName
                )
                imageRelic.setImageResource(iconId)
        }
    }

    private fun showInfoAlert(text: String) {
        val builder = AlertDialog.Builder(this@ItemActivity)
        builder.setTitle("Описание пути")
            .setMessage(text)
            .setCancelable(false)
            .setNegativeButton("Закрыть окно") { dialogInterface, _ ->
                dialogInterface.cancel()
            }
        val dialog = builder.create()
        dialog.show()
    }

}