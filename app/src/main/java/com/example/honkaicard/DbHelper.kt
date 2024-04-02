package com.example.honkaicard
import android.content.ClipDescription
import android.content.ContentValues
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
class DbHelper (val context: Context, val factory:SQLiteDatabase.CursorFactory?):
SQLiteOpenHelper(context, "app", factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE paths (id INT PRIMARY KEY, name TEXT, description TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    db!!.execSQL("DROP TABLE IF EXISTS paths")
        onCreate(db)
    }

    fun addPath(path:Path){
        val values = ContentValues()
        values.put("name", path.name)
        values.put("description", path.description)

        val db = this.writableDatabase
        db.insert("paths", null, values)

        db.close()
    }
    fun getPath(name: String, description: String){
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM paths", null)
//return result.moveToFirst()
    }
}

