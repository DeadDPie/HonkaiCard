package com.example.honkaicard

import org.junit.Assert.*

import org.junit.Test

class CharacterTest {


    @Test
    fun getId() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals(1, character.id)
    }

    @Test
    fun getImage() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals("image", character.image)
    }

    @Test
    fun getName() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals("name", character.name)
    }

    @Test
    fun getDesc() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals("desc", character.desc)
    }

    @Test
    fun getRare() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals("rare", character.rare)
    }

    @Test
    fun getPath() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals(123, character.path)
    }

    @Test
    fun getRelics() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals("relics", character.relics)
    }

    @Test
    fun getTypeOfDamage() {
        val character =
            Character(1, "image", "name", "desc", "rare", 123, "relics", "typeOfDamage", 0)
        assertEquals("typeOfDamage", character.typeOfDamage)
    }

    @Test
    fun getFav() {
        val character =
            Character(1, "image", "name", "desc", "rare",
                123, "relics", "typeOfDamage", 0)
        assertEquals(0, character.fav)
    }

    @Test
    fun setFav() {
        val character =
            Character(1, "image", "name", "desc", "rare",
                123, "relics", "typeOfDamage", 0)
        character.fav = 1
        assertEquals(1, character.fav)
    }
}