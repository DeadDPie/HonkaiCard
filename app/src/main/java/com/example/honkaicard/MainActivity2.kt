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

        val db = DbHelper(this, null)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()
        val itemsToShow = arrayListOf<Item>()

        val typeOfDamageFiz: String = "Физический"
        val typeOfDamageFire: String = "Огненный"
        val typeOfDamageIce: String = "Ледяной"
        val typeOfDamageElectro: String = "Электрический"
        val typeOfDamageWind: String = "Ветряной"
        val typeOfDamageKvant: String = "Квантовый"
        val typeOfDamageMnim: String = "Мнимый"
        //val path = Path("PathName", "PathDesc")
        val pathDestruction = Path(1, "Разрушение", "Персонажи этого Пути превосходно атакуют спереди. Они самые сильные, когда сражаются в одиночку в бою.")
        val pathHunt = Path(2, "Охота", "Персонажи этого Пути обладают экстраординарным уроном по одиночной цели, что критично в блиц-сражениях.")
        val pathErudition = Path(3, "Эрудиция", "Персонажи этого Пути обладают исключительным многоцелевым уроном по области. Используйте их способности в нужный момент, чтобы переломить ход битвы.")
        val pathHarmony = Path(4, "Гармония", "Персонажи этого Пути усиливают своих союзников и сотрудничают с союзниками, чтобы повысить общую боевую мощь отряда.")
        val pathNonexistence = Path(5, "Небытие", "Персонажи этого Пути будут ослаблять своих врагов и получать преимущество, уменьшая общую боевую мощь врага.")
        val pathPreservation = Path(7, "Сохранение", "Персонажи этого Пути обладают мощными защитными способностями, которые могут защитить союзников разными способами.")
        val pathAbundance = Path(8, "Изобилие", "Персонажи пути Изобилия выполняют роль лекарей в группе и могут исцелить как себя, так и всю команду.")



        items.add(Item(1, "gepard", "Гепард","Честный и благородный командующий Среброгривых Стражей носит имя уважаемой семьи Ландау.\n" +
                "В скованном льдом Белобоге жизнь идёт своим чередом...\n" +
                "И всё это благодаря стараниям Гепарда и его Стражей, что охраняют мир в городе.",
            "4",
            pathAbundance.id, "relics1", typeOfDamageIce, false))
        items.add(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "4", pathAbundance.id, "relics12", typeOfDamageFiz , false ))
        items.add(Item(8, "sampo", "Сампо","Продажник с хорошо подвешенным языком. Если где-то можно на чём-то нажиться, вы точно найдёте там Сампо.\n" +
                "Многие обращаются к нему за помощью, так как он владеет уникальными знаниями, но стать «клиентом» Сампо — не всегда хорошая идея.",
            "4",
            pathNonexistence.id, "relics1", typeOfDamageIce, false))
        items.add(Item(4, "march", "Март 7","Энергичная и эксцентричная девушка, интересующаяся всем, что нравится девочкам её возраста, к примеру, фотографией.\n" +
                "Её обнаружили в глыбе дрейфующего вечного льда, а после пробуждения оказалось, что она ничего не знает ни о себе, ни о своём прошлом.\n" +
                "Поначалу сильно этим подавленная, она решила назвать себя в честь даты, с которой пошла её новая жизнь.\n" +
                "И так появилась Март 7.",
            "4", pathPreservation.id, "relics12", typeOfDamageIce , false))
        items.add(Item(11, "chinlu", "Цзинлю","Легендарная героиня из Заоблачного квинтета, получившая прозвище Непостижимая Зарница.\n" +
                "Отринув привычные людские представления об исходе битвы, она выбрала другой путь, чтобы обрести силу, способную уничтожать богов.",
            "5", pathDestruction.id, "relics12", typeOfDamageIce , false))
        items.add(Item(5, "blade", "Блэйд","Мечник, всецело отдавший себя клинку. Данное при рождении имя неизвестно.\n" +
                "Он поклялся в верности Рабу Судьбы и обрёл невиданные способности к самоисцелению.\n" +
                "Блэйд орудует старинным мечом, который покрыт трещинами точно так же, как тело и разум его владельца.",
            "5", pathDestruction.id, "relics12", typeOfDamageWind , false))
        items.add(Item(3, "yan", "Яньцин","Энергичный лейтенант Лофу Сяньчжоу, а также самый умелый из мечников.\n" +
                "Он с рождения одержим мечами. Когда меч ложится в его в руку, никто не смеет недооценивать этого молодого гения.\n" +
                "Пожалуй, лишь время способно притупить его драгоценный клинок..",
            "5", pathHunt.id, "relics12", typeOfDamageIce, false ))
        items.add(Item(5, "avanturine", "Авантюрин","Топ-менеджер отдела стратегических инвестиций КММ и один из Десяти каменных сердец, известен своим основополагающим трудом «Авантюриновы стратагемы».\n" +
                "Яркая личность. Живёт по принципу «кто не рискует, тот не пьёт шампанского». Скрывает свои истинные намерения за неизменной улыбкой.",
            "5", pathPreservation.id, "relics12", typeOfDamageMnim , false))
        items.add(Item(13, "velt", "Вельт","Мудрый и опытный бывший властитель Антиэнтропии, унаследовавший имя мира — Вельт.\n" +
                "Много раз спасал Землю от уничтожения. После окончания событий в Сен-Фонтейне, Вельту ничего не оставалось, кроме как пройти через портал вместе с виновником этих событий.\n" +
                "Возможно, он и сам не ожидал ни нового путешествия, ни встреч с новыми спутниками.",
            "5", pathNonexistence.id, "relics12", typeOfDamageMnim , false))
        items.add(Item(24, "ratio", "Доктор Рацио","Прямой и эгоцентричный учёный из Гильдии эрудитов, который не расстаётся со своей странной гипсовой маской.\n" +
                "С детства он проявлял выдающиеся способности и талант, но теперь считает себя «заурядным».\n" +
                "Он убеждён, что знания и творчество не принадлежат исключительно гениям. Он стремится наполнить вселенную знаниями, дабы исцелить её от невежества.",
            "5", pathHunt.id, "relics12", typeOfDamageMnim , false))
        items.add(Item(14, "zele", "Зеле","Бойкая и храбрая Зеле из Дикого Огня выросла в Подземье Белобога, поэтому привыкла полагаться только на себя. Защитники и те, кого они защищают, угнетатели и угнетённые...\n" +
                "Мир, в котором росла Зеле, был чётко разделён на две части, и другого она не знала...",
            "5", pathHunt.id, "relics12", typeOfDamageKvant , false))
        items.add(Item(15, "kafka", "Кафка","В перечне лиц, разыскиваемых Корпорацией межзвёздного мира, в записи о Кафке указаны лишь её имя и одна фраза:\n" +
                "«Коллекционирует накидки». Об этой Охотнице за Стеллароном мало что известно, кроме того, что она является одним из самых доверенных лиц Раба судьбы Элио.\n" +
                "Кафка делает всё возможное ради воплощения в жизнь будущего, о котором так мечтает Элио.",
            "5", pathNonexistence.id, "relics12", typeOfDamageElectro , false))
        items.add(Item(16, "galher", "Галлахер","Офицер из клана Гончих на Пенаконии, а также неряшливый и ленивый бармен.\n" +
                "Одет небрежно, готовит напитки спонтанно, относится к посетителям с уважением, но с насторожённостью.\n" +
                "Кажется, у него довольно непростое прошлое, хотя он редко говорит о нём.",
            "4", pathAbundance.id, "relics12", typeOfDamageFire , false))

        if (savedInstanceState != null) {
            buttonText = savedInstanceState.getString("buttonText").toString()
        }
if (buttonText == "4"){
    items.removeIf { it.rare == "5" }

}
        if (buttonText == "5"){
            items.removeIf { it.rare == "4" }
        }
        if (buttonText == "typeOfDamageFiz"){
            items.removeIf { it.typeOfDamage != typeOfDamageFiz }
        }
        if (buttonText == "typeOfDamageElectro"){
            items.removeIf { it.typeOfDamage != typeOfDamageElectro }
        }
        if (buttonText == "typeOfDamageFire"){
            items.removeIf { it.typeOfDamage != typeOfDamageFire }
        }
        if (buttonText == "typeOfDamageIce"){
            items.removeIf { it.typeOfDamage != typeOfDamageIce }
        }
        if (buttonText == "typeOfDamageKvant"){
            items.removeIf { it.typeOfDamage != typeOfDamageKvant }
        }
        if (buttonText == "typeOfDamageMnim"){
            items.removeIf { it.typeOfDamage != typeOfDamageMnim }
        }
        if (buttonText == "typeOfDamageWind"){
            items.removeIf { it.typeOfDamage != typeOfDamageWind }
        }
        if (buttonText == "fav"){
            items.removeIf { !it.ff }
        }

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)



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
            pith, "relics1", typeOfDamageIce))
        items.add(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "4", pathAbundance, "relics12", typeOfDamageFiz  ))

        items.add(Item(3, "yan", "Яньцин","Энергичный лейтенант Лофу Сяньчжоу, а также самый умелый из мечников.\n" +
                "Он с рождения одержим мечами. Когда меч ложится в его в руку, никто не смеет недооценивать этого молодого гения.\n" +
                "Пожалуй, лишь время способно притупить его драгоценный клинок..",
            "5", pathHunt, "relics12", typeOfDamageIce ))

        items.add(Item(4, "march", "Март 7","Энергичная и эксцентричная девушка, интересующаяся всем, что нравится девочкам её возраста, к примеру, фотографией.\n" +
                "Её обнаружили в глыбе дрейфующего вечного льда, а после пробуждения оказалось, что она ничего не знает ни о себе, ни о своём прошлом.\n" +
                "Поначалу сильно этим подавленная, она решила назвать себя в честь даты, с которой пошла её новая жизнь.\n" +
                "И так появилась Март 7.",
            "4", pathPreservation, "relics12", typeOfDamageIce ))

        items.add(Item(5, "chinlu", "Цзинлю","Легендарная героиня из Заоблачного квинтета, получившая прозвище Непостижимая Зарница.\n" +
                "Отринув привычные людские представления об исходе битвы, она выбрала другой путь, чтобы обрести силу, способную уничтожать богов.",
            "5", pathDestruction, "relics12", typeOfDamageIce ))
        items.add(Item(5, "blade", "Блэйд","Мечник, всецело отдавший себя клинку. Данное при рождении имя неизвестно.\n" +
                "Он поклялся в верности Рабу Судьбы и обрёл невиданные способности к самоисцелению.\n" +
                "Блэйд орудует старинным мечом, который покрыт трещинами точно так же, как тело и разум его владельца.",
            "5", pathDestruction, "relics12", typeOfDamageWind ))*/

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
            pathHarmony.id, "relics1", typeOfDamageIce))
        db.addItem(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "4", pathAbundance.id, "relics12", typeOfDamageFiz  ))

        db.addItem(Item(3, "yan", "Яньцин","Энергичный лейтенант Лофу Сяньчжоу, а также самый умелый из мечников.\n" +
                "Он с рождения одержим мечами. Когда меч ложится в его в руку, никто не смеет недооценивать этого молодого гения.\n" +
                "Пожалуй, лишь время способно притупить его драгоценный клинок..",
            "5", pathHunt.id, "relics12", typeOfDamageIce ))

        db.addItem(Item(4, "march", "Март 7","Энергичная и эксцентричная девушка, интересующаяся всем, что нравится девочкам её возраста, к примеру, фотографией.\n" +
                "Её обнаружили в глыбе дрейфующего вечного льда, а после пробуждения оказалось, что она ничего не знает ни о себе, ни о своём прошлом.\n" +
                "Поначалу сильно этим подавленная, она решила назвать себя в честь даты, с которой пошла её новая жизнь.\n" +
                "И так появилась Март 7.",
            "4", pathPreservation.id, "relics12", typeOfDamageIce ))

        db.addItem(Item(5, "chinlu", "Цзинлю","Легендарная героиня из Заоблачного квинтета, получившая прозвище Непостижимая Зарница.\n" +
                "Отринув привычные людские представления об исходе битвы, она выбрала другой путь, чтобы обрести силу, способную уничтожать богов.",
            "5", pathDestruction.id, "relics12", typeOfDamageIce ))
        db.addItem(Item(5, "blade", "Блэйд","Мечник, всецело отдавший себя клинку. Данное при рождении имя неизвестно.\n" +
                "Он поклялся в верности Рабу Судьбы и обрёл невиданные способности к самоисцелению.\n" +
                "Блэйд орудует старинным мечом, который покрыт трещинами точно так же, как тело и разум его владельца.",
            "5", pathDestruction.id, "relics12", typeOfDamageWind ))
        db.addItem(Item(5, "avanturine", "Авантюрин","Топ-менеджер отдела стратегических инвестиций КММ и один из Десяти каменных сердец, известен своим основополагающим трудом «Авантюриновы стратагемы».\n" +
                "Яркая личность. Живёт по принципу «кто не рискует, тот не пьёт шампанского». Скрывает свои истинные намерения за неизменной улыбкой.",
            "5", pathPreservation.id, "relics12", typeOfDamageMnim ))*/