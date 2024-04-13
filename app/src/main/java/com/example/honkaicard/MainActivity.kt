package com.example.honkaicard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{

            val path = Path(5,"itsnewpath", "PathDesc")
            val db = DbHelper(this, null)
            //db.del("app")
            db.addPath(path)
            db.addItem(Item(1, "gepard", "Гепард","Честный и благородный командующий Среброгривых Стражей носит имя уважаемой семьи Ландау.\n" +
                    "В скованном льдом Белобоге жизнь идёт своим чередом...\n" +
                    "И всё это благодаря стараниям Гепарда и его Стражей, что охраняют мир в городе.",
                "4",
                2, "relics1", "dfdfg"))
            Toast.makeText(this, "Path was added", Toast.LENGTH_SHORT).show()


        }

        val button_go: Button = findViewById(R.id.button_go)
        button_go.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }
}