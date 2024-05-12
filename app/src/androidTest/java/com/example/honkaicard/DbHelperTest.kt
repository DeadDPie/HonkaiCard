package com.example.honkaicard

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DbHelperTest {

    private lateinit var dbHelper: DbHelper
    private lateinit var db: SQLiteDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        dbHelper = DbHelper(context, null)
        db = dbHelper.writableDatabase
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun testGetPathById() {
        val path = dbHelper.getPathById(1)
        assertEquals(1, path.id)
        assertEquals("Разрушение", path.name)
    }
    @Test
    fun testGetLike() {
        val like = dbHelper.getLike(1)
        assertEquals(0, like)
    }
    @Test
    fun testSetLike() {
        dbHelper.setLike(2)
        val like = dbHelper.getLike(2)
        assertEquals(1, like)
        dbHelper.setLike(2)
        val new_like = dbHelper.getLike(2)
        assertEquals(0, new_like)

    }
    @Test
    fun testGetAllCharacters(){
        assertNotNull(dbHelper.getAllCharacters())
    }
}
