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
    val charactersFiltered = arrayListOf<Character>()

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
            false
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
            false

        )
        )
        val itemsToShow = arrayListOf<Character>()
        val charactersToShow = db.getAllCharacters()
        charactersFiltered += charactersToShow


        if (savedInstanceState != null) {
            buttonText = savedInstanceState.getString("buttonText").toString()
        }
        if (buttonText == "4") {
            charactersFiltered.removeIf { it.rare == "5" }

        }
        if (buttonText == "5") {
            //characters.removeIf { it.rare == "4" }
            charactersFiltered.clear()
//            //val chars = mutableListOf<Item>()
            charactersFiltered += db.getCharByRare("4")
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
            charactersFiltered.removeIf { !it.fav }
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
/*
        items.add(Item(1, "gepard", "Гепард","Честный и благородный командующий Среброгривых Стражей носит имя уважаемой семьи Ландау.\n" +
                "В скованном льдом Белобоге жизнь идёт своим чередом...\n" +
                "И всё это благодаря стараниям Гепарда и его Стражей, что охраняют мир в городе.",
             "4",
            pith, "relics1", iceDamage))
        items.add(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "4", pathAbundance, "relics12", physicalDamage  ))

        items.add(Item(3, "yan", "Яньцин","Энергичный лейтенант Лофу Сяньчжоу, а также самый умелый из мечников.\n" +
                "Он с рождения одержим мечами. Когда меч ложится в его в руку, никто не смеет недооценивать этого молодого гения.\n" +
                "Пожалуй, лишь время способно притупить его драгоценный клинок..",
            "5", pathHunt, "relics12", iceDamage ))

        items.add(Item(4, "march", "Март 7","Энергичная и эксцентричная девушка, интересующаяся всем, что нравится девочкам её возраста, к примеру, фотографией.\n" +
                "Её обнаружили в глыбе дрейфующего вечного льда, а после пробуждения оказалось, что она ничего не знает ни о себе, ни о своём прошлом.\n" +
                "Поначалу сильно этим подавленная, она решила назвать себя в честь даты, с которой пошла её новая жизнь.\n" +
                "И так появилась Март 7.",
            "4", pathPreservation, "relics12", iceDamage ))

        items.add(Item(5, "chinlu", "Цзинлю","Легендарная героиня из Заоблачного квинтета, получившая прозвище Непостижимая Зарница.\n" +
                "Отринув привычные людские представления об исходе битвы, она выбрала другой путь, чтобы обрести силу, способную уничтожать богов.",
            "5", pathDestruction, "relics12", iceDamage ))
        items.add(Item(5, "blade", "Блэйд","Мечник, всецело отдавший себя клинку. Данное при рождении имя неизвестно.\n" +
                "Он поклялся в верности Рабу Судьбы и обрёл невиданные способности к самоисцелению.\n" +
                "Блэйд орудует старинным мечом, который покрыт трещинами точно так же, как тело и разум его владельца.",
            "5", pathDestruction, "relics12", windDamage ))*/

/*
        db.addPath(pathAbundance)
        db.addPath(pathPreservation)
        db.addPath(pathNonexistence)
        db.addPath(pathHarmony)
        db.addPath(pathErudition)
        db.addPath(pathHunt)
        db.addPath(pathDestruction)

 val chars = db.getCharByRare("4").toMutableList()
        for (char in chars) {
            items.add(char)
            Toast.makeText(this, "char was added", Toast.LENGTH_SHORT).show()
        }

        db.addItem(Item(1, "gepard", "Гепард","Честный и благородный командующий Среброгривых Стражей носит имя уважаемой семьи Ландау.\n" +
                "В скованном льдом Белобоге жизнь идёт своим чередом...\n" +
                "И всё это благодаря стараниям Гепарда и его Стражей, что охраняют мир в городе.",
            "4",
            pathHarmony.id, "relics1", iceDamage))
        db.addItem(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "4", pathAbundance.id, "relics12", physicalDamage  ))

        db.addItem(Item(3, "yan", "Яньцин","Энергичный лейтенант Лофу Сяньчжоу, а также самый умелый из мечников.\n" +
                "Он с рождения одержим мечами. Когда меч ложится в его в руку, никто не смеет недооценивать этого молодого гения.\n" +
                "Пожалуй, лишь время способно притупить его драгоценный клинок..",
            "5", pathHunt.id, "relics12", iceDamage ))

        db.addItem(Item(4, "march", "Март 7","Энергичная и эксцентричная девушка, интересующаяся всем, что нравится девочкам её возраста, к примеру, фотографией.\n" +
                "Её обнаружили в глыбе дрейфующего вечного льда, а после пробуждения оказалось, что она ничего не знает ни о себе, ни о своём прошлом.\n" +
                "Поначалу сильно этим подавленная, она решила назвать себя в честь даты, с которой пошла её новая жизнь.\n" +
                "И так появилась Март 7.",
            "4", pathPreservation.id, "relics12", iceDamage ))

        db.addItem(Item(5, "chinlu", "Цзинлю","Легендарная героиня из Заоблачного квинтета, получившая прозвище Непостижимая Зарница.\n" +
                "Отринув привычные людские представления об исходе битвы, она выбрала другой путь, чтобы обрести силу, способную уничтожать богов.",
            "5", pathDestruction.id, "relics12", iceDamage ))
        db.addItem(Item(5, "blade", "Блэйд","Мечник, всецело отдавший себя клинку. Данное при рождении имя неизвестно.\n" +
                "Он поклялся в верности Рабу Судьбы и обрёл невиданные способности к самоисцелению.\n" +
                "Блэйд орудует старинным мечом, который покрыт трещинами точно так же, как тело и разум его владельца.",
            "5", pathDestruction.id, "relics12", windDamage ))
        db.addItem(Item(5, "avanturine", "Авантюрин","Топ-менеджер отдела стратегических инвестиций КММ и один из Десяти каменных сердец, известен своим основополагающим трудом «Авантюриновы стратагемы».\n" +
                "Яркая личность. Живёт по принципу «кто не рискует, тот не пьёт шампанского». Скрывает свои истинные намерения за неизменной улыбкой.",
            "5", pathPreservation.id, "relics12", imaginaryDamage ))*/