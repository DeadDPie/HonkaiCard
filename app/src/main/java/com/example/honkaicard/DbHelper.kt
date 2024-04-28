package com.example.honkaicard
import android.content.ContentValues
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
class DbHelper (val context: Context, val factory:SQLiteDatabase.CursorFactory?):
SQLiteOpenHelper(context, "app", factory, 5){
    override fun onCreate(db: SQLiteDatabase?) {
        val createPathsTableQuery  = "CREATE TABLE paths (id INT PRIMARY KEY, name TEXT, description TEXT)"
        db!!.execSQL(createPathsTableQuery )

// Создаем таблицу "items" для хранения персонажей
        val createItemsTableQuery = "CREATE TABLE items (" +
                "id INTEGER PRIMARY KEY, " +
                "image TEXT, " +
                "name TEXT, " +
                "description TEXT, " +

                "rare TEXT, " +
                "path_id INTEGER, " +
                "relics TEXT, " +
                "typeOfDamage TEXT, " +
                "fav TEXT, "+
                "FOREIGN KEY(path_id) REFERENCES paths(id))"

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


    fun getPath(id:Int): String {

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
        return path!!
}
    fun addPath(path:Path){
        val values = ContentValues()
        values.put("id", path.id)
        values.put("name", path.name)
        values.put("description", path.description)

        val db = this.writableDatabase
        db.insert("paths", null, values)

        db.close()
    }
    fun addItem(item: Item) {

        val values = ContentValues()
        values.put("id", item.id)
        values.put("image", item.image)
        values.put("title", item.name)
        values.put("description", item.desc)
        values.put("rare", item.rare)
        values.put("path_id", item.path)
        values.put("relics", item.relics)
        values.put("typeOfDamage", item.typeOfDamage)
        values.put("fav", item.fav)

        val db = this.writableDatabase
        db.insert("items", null, values)
        db.close()
    }

    fun getCharByRare(rare: String): List<Item> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM items WHERE rare = ?", arrayOf(rare))
        val chars = mutableListOf<Item>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val image = cursor.getString(cursor.getColumnIndexOrThrow("image"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
            val pathId = cursor.getInt(cursor.getColumnIndexOrThrow("path_id"))
            val relics = cursor.getString(cursor.getColumnIndexOrThrow("relics"))
            val typeOfDamage = cursor.getString(cursor.getColumnIndexOrThrow("typeOfDamage"))

            val path = getPathById(pathId)

            val char = Item(id, image, name, description, rare, pathId, relics, typeOfDamage, false)
            chars.add(char)
        }

        cursor.close()
        return chars
    }


}

