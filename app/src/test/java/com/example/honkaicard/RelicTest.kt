package com.example.honkaicard

import org.junit.Assert.*

import org.junit.Test

class RelicTest {

    @Test
    fun getId() {
        val relic = Relic(1, "image_url", "relic_name")

        assertEquals(1, relic.id)
    }

    @Test
    fun getImage() {
        val relic = Relic(1, "image_url", "relic_name")

        assertEquals("image_url", relic.image)
    }

    @Test
    fun getName() {
        val relic = Relic(1, "image_url", "relic_name")

        assertEquals("relic_name", relic.name)
    }
}