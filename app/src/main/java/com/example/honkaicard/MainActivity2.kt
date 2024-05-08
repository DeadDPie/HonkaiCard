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

class MainActivity2 : AppCompatActivity(), OnButtonClickListener {

    private var buttonText: String = ""


    override fun onButtonFourClicked(text: String) {
        //recreate()
        // Делайте что-то с полученной строкой
        buttonText = text
        recreate()
        //Toast.makeText(this, "Нажата кнопка: $text", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("buttonText", buttonText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //charactersFiltered += characters
        val db = DbHelper(this, null)
        db.initPaths()
        val charactersList: RecyclerView = findViewById(R.id.itemsList)


        val itemsToShow = arrayListOf<Character>()
        val charactersToShow = db.getAllCharacters()
        var charactersFiltered = charactersToShow as ArrayList<Character>
//         charactersFiltered = charactersToShow as ArrayList<Character>


        if (savedInstanceState != null) {
            buttonText = savedInstanceState.getString("buttonText").toString()
        }
        if (buttonText == "4") {
//            charactersFiltered.clear()
//            charactersFiltered += db.getCharByRare("4")
            db.addCharacter(Character(
                15,
                "bailu",
                "Байлу",
                "Жизнерадостная девушка видьядхарского происхождения, прозванная Целительницей-драконом за свой богатый опыт в медицине.\n" +
                        "Часто выписывает нестандартные назначения, например, «пейте больше воды» или «как следует высыпайтесь».\n" +
                        "Байлу тяжело смотреть на страдания других, поэтому она лечит пациентов крепко зажмурив глаза.\n" +
                        "«Главное — чтобы все были здоровы, верно?»",
                "5",
                abundance.id,
                "relics12",
                lightningDamage,
                0
            ))
            db.addCharacter(Character(
                14,
                "arlan",
                "Арлан",
                "Немногословный глава Отдела безопасности космической станции «Герта».\n" +
                        "Арлан ничего не понимает в научных исследованиях, но готов пожертвовать своей жизнью ради защиты сотрудников станции, для которых эти исследования значат очень многое. Он не боится боли и носит шрамы с достоинством.\n" +
                        "Только вместе с Пеппи парень может позволить себе расслабиться и улыбнуться.",
                "4",
                destruction.id,
                "relics12",
                lightningDamage,
                0

            )
            )

        }
        if (buttonText == "5") {
            //characters.removeIf { it.rare == "4" }
            charactersFiltered.clear()
//            //val chars = mutableListOf<Item>()
            charactersFiltered += db.getCharByRare("5")
        }
        if (buttonText == "physicalDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != physicalDamage }
        }
        if (buttonText == "lightningDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != lightningDamage }
        }
        if (buttonText == "fireDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != fireDamage }
        }
        if (buttonText == "iceDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != iceDamage }
        }
        if (buttonText == "quantumDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != quantumDamage }
        }
        if (buttonText == "imaginaryDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != imaginaryDamage }
        }
        if (buttonText == "windDamage") {
            charactersFiltered.removeIf { it.typeOfDamage != windDamage }
        }
        if (buttonText == "liked") {
            charactersFiltered.removeIf {db.getLike(it.id) == 0 }
        }


//        if (buttonText == "fav"){
//            characters.removeIf { !it.fav  }
//        }
//        if (buttonText.startsWith("Ffav")) {
//            val itemId = buttonText.substringAfter("Ffav")
//            val item = characters.find { it.id == itemId.toInt() }
//            item?.let {
//                it.fav = true
//                //charactersAdapter.notifyItemChanged(characters.indexOf(it))
//            }
//        }


        charactersList.layoutManager = LinearLayoutManager(this)
        charactersList.adapter = ItemsAdapter(charactersFiltered, this)


        val button: Button = findViewById(R.id.item_list_button)
        button.setOnClickListener {
            val bottomSheetDialogFragment = MyBottomSheetDialogFragment()
            bottomSheetDialogFragment.show(supportFragmentManager, "bottomSheetDialogFragment")
        }

    }

}
