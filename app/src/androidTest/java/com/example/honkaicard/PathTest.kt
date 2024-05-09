package com.example.honkaicard

import org.junit.Assert.*

import org.junit.Test

class PathTest {

    @Test
    fun getId() {
        val path = Path(1, "name", "description")
        assertEquals(1, path.id)
    }
    @Test
    fun getName() {
        val path = Path(1, "name", "description")
        assertEquals("name", path.name)
    }

    @Test
    fun getDescription() {
        val path = Path(1, "name", "description")
        assertEquals("description", path.description)
    }
}