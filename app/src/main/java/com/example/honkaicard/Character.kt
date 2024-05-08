package com.example.honkaicard

class Character(
    val id: Int,
    val image: String,
    val name: String,
    val desc: String,
    val rare: String,
    val path: Int,
    val relics: String,
    val typeOfDamage: String,
    var fav: Int
) {
//    var ff: Boolean = 0
//    fun ffavor(){
//        ff = !ff
//    }
//    fun favor(){
//        fav = !fav
//    }

}//title

const val physicalDamage: String = "Физический"
const val fireDamage: String = "Огненный"
const val iceDamage: String = "Ледяной"
const val lightningDamage: String = "Электрический"
const val windDamage: String = "Ветряной"
const val quantumDamage: String = "Квантовый"
const val imaginaryDamage: String = "Мнимый"


var sampo =
    Character(
        1,
        "sampo",
        "Сампо",
        "Продажник с хорошо подвешенным языком. Если где-то можно на чём-то нажиться, вы точно найдёте там Сампо.\n" +
                "Многие обращаются к нему за помощью, так как он владеет уникальными знаниями, но стать «клиентом» Сампо — не всегда хорошая идея.",
        "4",
        nihility.id,
        "relics1",
        windDamage,
        0
    )


var gepard =
    Character(
        2,
        "gepard",
        "Гепард",
        "Честный и благородный командующий Среброгривых Стражей носит имя уважаемой семьи Ландау.\n" +
                "В скованном льдом Белобоге жизнь идёт своим чередом...\n" +
                "И всё это благодаря стараниям Гепарда и его Стражей, что охраняют мир в городе.",
        "5",
        preservation.id,
        "relics1",
        iceDamage,
        0
    )

var natasha =
    Character(
        3,
        "natasha",
        "Наташа",
        "На лице придирчивого доктора всегда играет хитрая улыбка.\n" +
                "В Подземье, где всегда не хватает медикаментов, Наташа — одна из немногих, к кому люди могут обратиться за помощью.",
        "4",
        abundance.id,
        "relics12",
        physicalDamage,
        0
    )


var march = Character(
    4,
    "march",
    "Март 7",
    "Энергичная и эксцентричная девушка, интересующаяся всем, что нравится девочкам её возраста, к примеру, фотографией.\n" +
            "Её обнаружили в глыбе дрейфующего вечного льда, а после пробуждения оказалось, что она ничего не знает ни о себе, ни о своём прошлом.\n" +
            "Поначалу сильно этим подавленная, она решила назвать себя в честь даты, с которой пошла её новая жизнь.\n" +
            "И так появилась Март 7.",
    "4",
    preservation.id,
    "relics12",
    iceDamage,
    0
)


var chinlu = Character(
    5,
    "chinlu",
    "Цзинлю",
    "Легендарная героиня из Заоблачного квинтета, получившая прозвище Непостижимая Зарница.\n" +
            "Отринув привычные людские представления об исходе битвы, она выбрала другой путь, чтобы обрести силу, способную уничтожать богов.",
    "5",
    destruction.id,
    "relics12",
    iceDamage,
    0
)


var blade = Character(
    6,
    "blade",
    "Блэйд",
    "Мечник, всецело отдавший себя клинку. Данное при рождении имя неизвестно.\n" +
            "Он поклялся в верности Рабу Судьбы и обрёл невиданные способности к самоисцелению.\n" +
            "Блэйд орудует старинным мечом, который покрыт трещинами точно так же, как тело и разум его владельца.",
    "5",
    destruction.id,
    "relics12",
    windDamage,
    0
)


var yan = Character(
    7,
    "yan",
    "Яньцин",
    "Энергичный лейтенант Лофу Сяньчжоу, а также самый умелый из мечников.\n" +
            "Он с рождения одержим мечами. Когда меч ложится в его в руку, никто не смеет недооценивать этого молодого гения.\n" +
            "Пожалуй, лишь время способно притупить его драгоценный клинок..",
    "5",
    hunt.id,
    "relics12",
    iceDamage,
    0
)


var avanturine = Character(
    8,
    "avanturine",
    "Авантюрин",
    "Топ-менеджер отдела стратегических инвестиций КММ и один из Десяти каменных сердец, известен своим основополагающим трудом «Авантюриновы стратагемы».\n" +
            "Яркая личность. Живёт по принципу «кто не рискует, тот не пьёт шампанского». Скрывает свои истинные намерения за неизменной улыбкой.",
    "5",
    preservation.id,
    "relics12",
    imaginaryDamage,
    0
)


var velt = Character(
    9,
    "velt",
    "Вельт",
    "Мудрый и опытный бывший властитель Антиэнтропии, унаследовавший имя мира — Вельт.\n" +
            "Много раз спасал Землю от уничтожения. После окончания событий в Сен-Фонтейне, Вельту ничего не оставалось, кроме как пройти через портал вместе с виновником этих событий.\n" +
            "Возможно, он и сам не ожидал ни нового путешествия, ни встреч с новыми спутниками.",
    "5",
    nihility.id,
    "relics12",
    imaginaryDamage,
    0
)


var ratio = Character(
    10,
    "ratio",
    "Доктор Рацио",
    "Прямой и эгоцентричный учёный из Гильдии эрудитов, который не расстаётся со своей странной гипсовой маской.\n" +
            "С детства он проявлял выдающиеся способности и талант, но теперь считает себя «заурядным».\n" +
            "Он убеждён, что знания и творчество не принадлежат исключительно гениям. Он стремится наполнить вселенную знаниями, дабы исцелить её от невежества.",
    "5",
    hunt.id,
    "relics12",
    imaginaryDamage,
    0
)


var zele = Character(
    11,
    "zele",
    "Зеле",
    "Бойкая и храбрая Зеле из Дикого Огня выросла в Подземье Белобога, поэтому привыкла полагаться только на себя. Защитники и те, кого они защищают, угнетатели и угнетённые...\n" +
            "Мир, в котором росла Зеле, был чётко разделён на две части, и другого она не знала...",
    "5",
    hunt.id,
    "relics12",
    quantumDamage,
    0
)


var kafka = Character(
    12,
    "kafka",
    "Кафка",
    "В перечне лиц, разыскиваемых Корпорацией межзвёздного мира, в записи о Кафке указаны лишь её имя и одна фраза:\n" +
            "«Коллекционирует накидки». Об этой Охотнице за Стеллароном мало что известно, кроме того, что она является одним из самых доверенных лиц Раба судьбы Элио.\n" +
            "Кафка делает всё возможное ради воплощения в жизнь будущего, о котором так мечтает Элио.",
    "5",
    nihility.id,
    "relics12",
    lightningDamage,
    0
)


var galher = Character(
    13,
    "galher",
    "Галлахер",
    "Офицер из клана Гончих на Пенаконии, а также неряшливый и ленивый бармен.\n" +
            "Одет небрежно, готовит напитки спонтанно, относится к посетителям с уважением, но с насторожённостью.\n" +
            "Кажется, у него довольно непростое прошлое, хотя он редко говорит о нём.",
    "4",
    abundance.id,
    "relics12",
    fireDamage,
    0

)

var arlan = Character(
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

var bailu = Character(
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
)


val characters = arrayListOf(
    sampo,
    natasha,
    gepard,
    bailu,
    arlan,
    galher,
    kafka,
    zele,
    ratio,
    velt,
    avanturine,
    march,
    blade,
    chinlu,
    yan
)
