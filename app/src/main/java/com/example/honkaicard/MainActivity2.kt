package com.example.honkaicard

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val path = Path("PathName", "PathDesc")
        val path2 = Path(" Изобилие", "PathDesc")
        val db = DbHelper(this, null)
        db.addPath(path)
        Toast.makeText(this, "Path was added", Toast.LENGTH_LONG).show()

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()


        items.add(Item(1, "gepard", "Гепард","Divan", "meme", "rare1", path, "relics1", "typeOfDamage1"))
        items.add(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "df","4", path2, "relics12", "Физический"  ))
//widekit
        //kit

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)



        val button: Button = findViewById(R.id.item_list_button)
        button.setOnClickListener {
            val bottomSheetDialogFragment = MyBottomSheetDialogFragment()
            bottomSheetDialogFragment.show(supportFragmentManager, "bottomSheetDialogFragment")
        }
    }
}