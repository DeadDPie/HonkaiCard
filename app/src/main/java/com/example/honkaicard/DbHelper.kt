package com.example.honkaicard

import android.content.ContentValues
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log
import java.io.FileOutputStream

class DbHelper(private val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "base.db", null, 5) {

    init {
        if (!checkDatabase()) {
            copyDatabaseFromAssets()
        }
    }

    private fun checkDatabase(): Boolean {
        return context.getDatabasePath("base.db").exists()
    }

    private fun copyDatabaseFromAssets() {
        val inputStream = context.assets.open("predisigned_base.db")
        val outputStream = FileOutputStream(context.getDatabasePath("base.db"))

        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createPathsTableQuery =
            "CREATE TABLE paths (id INT PRIMARY KEY, name TEXT, description TEXT)"
        db!!.execSQL(createPathsTableQuery)


        // Создаем  таблицу "items" для хранения персонажей
        val createItemsTableQuery = "CREATE TABLE items (" +
                "id INTEGER PRIMARY KEY, " +
                "image TEXT, " +
                "name TEXT, " +
                "description TEXT, " +

                "rare TEXT, " +
                "path_id INTEGER, " +
                "relics TEXT, " +
                "typeOfDamage TEXT, " +
                "fav INTEGER )"
//                "FOREIGN KEY(path_id) REFERENCES paths(id))"

        // Проверяем, существует ли уже таблица items
        val query = "SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = 'items'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            db.execSQL(createItemsTableQuery)
        }
        cursor.close()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS paths")
        onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS items")
        onCreate(db)
    }


    fun getPath(id: Int): String {

        val db = this.readableDatabase
        /*
                val result = db.rawQuery("SELECT paths.name FROM paths", null)*//*WHERE paths.id = 3*/
//return result.moveToFirst()WHERE paths.id = $Pid
        //val cursor = db.rawQuery("SELECT paths.name FROM paths  ", null)
        val cursor = db.rawQuery("SELECT name FROM paths WHERE id = ?", arrayOf(id.toString()))
        val result: MutableList<String> = mutableListOf()

        if (cursor.moveToFirst()) {
            do {
                val pathName = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                result.add(pathName)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return result.last()
    }

    fun getPathById(id: Int): Path {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM paths WHERE id = ?", arrayOf(id.toString()))
        var path: Path? = null

        if (cursor.moveToFirst()) {
            val pathId = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))

            path = Path(pathId, name, description)
        }

        cursor.close()
        return path ?: destruction

    }


    fun initPaths() {
        val paths = listOf(destruction, hunt, erudition, harmony, nihility, preservation, abundance)
        val db = this.writableDatabase
        for (path in paths) {
            // проверяем, существуют ли данные с тем же id
            val cursor = db.query(
                "paths",
                arrayOf("id"),
                "id = ?",
                arrayOf(path.id.toString()),
                null,
                null,
                null
            )
            if (cursor.count == 0) {
                // если данных нет, добавляем их
                val values = ContentValues()
                values.put("id", path.id)
                values.put("name", path.name)
                values.put("description", path.description)
                db.insert("paths", null, values)
            }
            cursor.close()
        }
        db.close()
    }


    fun addCharacter(character: Character) {

        val values = ContentValues()
        values.put("id", character.id)
        values.put("image", character.image)
        values.put("name", character.name)
        values.put("description", character.desc)
        values.put("rare", character.rare)
        values.put("path_id", character.path)
        values.put("relics", character.relics)
        values.put("typeOfDamage", character.typeOfDamage)
        values.put("fav", character.fav)

        val db = this.writableDatabase
        db.insert("items", null, values)
        db.close()
    }

    fun getCharByRare(rare: String): List<Character> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM items WHERE rare = ?", arrayOf(rare))
        val chars = mutableListOf<Character>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val image = cursor.getString(cursor.getColumnIndexOrThrow("image"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
            val pathId = cursor.getInt(cursor.getColumnIndexOrThrow("path_id"))
            val relics = cursor.getString(cursor.getColumnIndexOrThrow("relics"))
            val typeOfDamage = cursor.getString(cursor.getColumnIndexOrThrow("typeOfDamage"))

            val path = getPathById(pathId)

            val char =
                Character(id, image, name, description, rare, pathId, relics, typeOfDamage, 0)
            chars.add(char)
        }

        cursor.close()
        return chars
    }

    fun getAllCharacters(): List<Character> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM items ", null)
        val all_characters = mutableListOf<Character>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val image = cursor.getString(cursor.getColumnIndexOrThrow("image"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
            val rare = cursor.getString(cursor.getColumnIndexOrThrow("rare"))
            val pathId = cursor.getInt(cursor.getColumnIndexOrThrow("path_id"))
            val relics = cursor.getString(cursor.getColumnIndexOrThrow("relics"))
            val typeOfDamage = cursor.getString(cursor.getColumnIndexOrThrow("typeOfDamage"))

            val character =
                Character(id, image, name, description, rare, pathId, relics, typeOfDamage, 0)
            all_characters.add(character)
        }

        cursor.close()
        return all_characters
    }

    fun getLike(id: Int): Int {
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM items WHERE id = ?", arrayOf(id.toString()))
        Log.d("MyTag", "clicked char id $id")
        var currentLike: Int = 0
        if (cursor.moveToFirst()) {
            currentLike = cursor.getInt(cursor.getColumnIndexOrThrow("fav"))
            Log.d("MyTag", "currentLike $currentLike")

        }
        return currentLike
    }

    fun setLike(id: Int) {
        val db = this.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM items WHERE id = ?", arrayOf(id.toString()))
        Log.d("MyTag", "clicked char id $id")

        if (cursor.moveToFirst()) {
            val currentLike = cursor.getInt(cursor.getColumnIndexOrThrow("fav"))
            Log.d("MyTag", "currentLike $currentLike")
            val newLike = if (currentLike == 0) 1 else 0 // Инвертируем значение fav
            Log.d("MyTag", "newLike $newLike")

            val contentValues = ContentValues().apply {
                put("fav", newLike)
            }

            db.update("items", contentValues, "id = ?", arrayOf(id.toString()))
        }

        cursor.close()
        db.close()
    }
}