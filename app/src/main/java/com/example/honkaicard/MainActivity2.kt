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
        buttonText = text
        recreate()
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
        val db = DbHelper(this, null)
        val charactersList: RecyclerView = findViewById(R.id.itemsList)
        val charactersToShow = db.getAllCharacters()
        var charactersFiltered = charactersToShow as ArrayList<Character>


        if (savedInstanceState != null) {
            buttonText = savedInstanceState.getString("buttonText").toString()
        }
        if (buttonText == "4") {
            charactersFiltered.clear()
            charactersFiltered += db.getCharByRare("4")
        }
        if (buttonText == "5") {
            charactersFiltered.clear()
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


        charactersList.layoutManager = LinearLayoutManager(this)
        charactersList.adapter = ItemsAdapter(charactersFiltered, this)


        val button: Button = findViewById(R.id.item_list_button)
        button.setOnClickListener {
            val bottomSheetDialogFragment = MyBottomSheetDialogFragment()
            bottomSheetDialogFragment.show(supportFragmentManager, "bottomSheetDialogFragment")
        }

    }

}
