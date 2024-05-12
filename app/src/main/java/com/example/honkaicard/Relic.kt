package com.example.honkaicard

class Relic (val id: Int, val image: String, override val name: String): Name {
    override fun getItemName(): String {
        return this.name
    }
}