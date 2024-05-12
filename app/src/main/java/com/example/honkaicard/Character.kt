package com.example.honkaicard

class Character(
    val id: Int,
    val image: String,
    override val name: String,
    val desc: String,
    val rare: String,
    val path: Int,
    val relics: String,
    val typeOfDamage: String,
    var fav: Int
) : Name {
    override fun getItemName(): String {
        return this.name
    }
}

const val physicalDamage: String = "Физический"
const val fireDamage: String = "Огненный"
const val iceDamage: String = "Ледяной"
const val lightningDamage: String = "Электрический"
const val windDamage: String = "Ветряной"
const val quantumDamage: String = "Квантовый"
const val imaginaryDamage: String = "Мнимый"
