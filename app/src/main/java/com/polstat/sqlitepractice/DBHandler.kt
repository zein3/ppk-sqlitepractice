package com.polstat.sqlitepractice

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(
    context: Context
) : SQLiteOpenHelper(
    context,
    DB_NAME,
    null,
    DB_VERSION
) {

    companion object {
        private const val DB_NAME = "mahasiswadb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "mahasiswatbl"
        private const val ID_COL = "id"
        private const val NIM_COL = "nim"
        private const val NAMA_COL = "nama"
        private const val KELAS_COL = "kelas"
        private const val NOHP_COL = "nohp"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE ${TABLE_NAME}(" +
                "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NIM_COL TEXT," +
                "$NAMA_COL TEXT," +
                "$KELAS_COL TEXT," +
                "$NOHP_COL TEXT)"

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addNewMahasiswa(nim: String, nama: String, kelas: String, nohp: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NIM_COL, nim)
        values.put(NAMA_COL, nama)
        values.put(KELAS_COL, kelas)
        values.put(NOHP_COL, nohp)

        db.insert(TABLE_NAME, null,  values)
        db.close()
    }

}