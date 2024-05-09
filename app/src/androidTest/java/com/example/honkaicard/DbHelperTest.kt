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
        db = dbHelper.readableDatabase
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
}
