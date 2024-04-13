package com.example.honkaicard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

        val path = Path(8,"Putii", "PathrtryDesc")
        val db = DbHelper(this, null)
        db.addPath(path)
        Toast.makeText(this, "Path was added", Toast.LENGTH_LONG).show()
        val pith: Path = db.getPathById(3)!!

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        val typeOfDamageFiz: String = "физический"
        val typeOfDamageFire: String = "огненный"
        val typeOfDamageIce: String = "ледяной"
        val typeOfDamageElectro: String = "электрический"
        val typeOfDamageWind: String = "ветряной"
        val typeOfDamageKvant: String = "квантовый"
        val typeOfDamageMnim: String = "мнимый"
        //val path = Path("PathName", "PathDesc")
        val pathDestruction = Path(1, "Разрушение", "Персонажи этого Пути превосходно атакуют спереди. Они самые сильные, когда сражаются в одиночку в бою.")
        val pathHunt = Path(2, "Охота", "Персонажи этого Пути обладают экстраординарным уроном по одиночной цели, что критично в блиц-сражениях.")
        val pathErudition = Path(3, "Эрудиция", "Персонажи этого Пути обладают исключительным многоцелевым уроном по области. Используйте их способности в нужный момент, чтобы переломить ход битвы.")
        val pathHarmony = Path(4, "Гармония", "Персонажи этого Пути усиливают своих союзников и сотрудничают с союзниками, чтобы повысить общую боевую мощь отряда.")
        val pathNonexistence = Path(5, "Небытие", "Персонажи этого Пути будут ослаблять своих врагов и получать преимущество, уменьшая общую боевую мощь врага.")
        val pathPreservation = Path(7, "Сохранение", "Персонажи этого Пути обладают мощными защитными способностями, которые могут защитить союзников разными способами.")
        val pathAbundance = Path(8, "Изобилие", "Персонажи пути Изобилия выполняют роль лекарей в группе и могут исцелить как себя, так и всю команду.")
        db.addPath(pathAbundance)
        db.addPath(pathPreservation)
        db.addPath(pathNonexistence)
        db.addPath(pathHarmony)
        db.addPath(pathErudition)
        db.addPath(pathHunt)
        db.addPath(pathDestruction)


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
            "5", pathDestruction, "relics12", typeOfDamageWind ))
//widekit
        //kit addItem



        val filter: String;

        filter = intent.getStringExtra("Filter").toString()
        if (filter == "4"){
            val chars = db.getCharByRare("4").toMutableList()

        }





        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)



/*

        db.addItem(Item(1, "gepard", "Гепард","Divan", "meme", "4",
            pith, "relics1", "typeOfDamage1"))
        db.addItem(Item(2, "natasha", "Наташа","На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
            "df","4", path2, "relics12", "faaa"  ))
        db.addItem(Item(3, "yan", "Яньцин","Нffrrrr.",
            "df","5", path2, "relics12", "Физический"  ))
        db.addItem(Item(3, "kit", "kit","Нffrrrr.",
            "df","5", path2, "relics12", "Физический"  ))
*/
        val button: Button = findViewById(R.id.item_list_button)
        button.setOnClickListener {
            val bottomSheetDialogFragment = MyBottomSheetDialogFragment()
            bottomSheetDialogFragment.show(supportFragmentManager, "bottomSheetDialogFragment")
        }
    }
}