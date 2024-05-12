package com.example.honkaicard


interface Name {
    val name: String
    fun getItemName(): String {
        return this.name
    }
}