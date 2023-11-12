package com.polstat.sqlitepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewMahasiswa : AppCompatActivity() {
    private lateinit var mahasiswaModalList: List<MahasiswaModal>
    private lateinit var dbHandler: DBHandler
    private lateinit var mahasiswaRVAdapter: MahasiswaRVAdapter
    private lateinit var mahasiswaRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mahasiswa)

        dbHandler = DBHandler(this)
        mahasiswaModalList = dbHandler.readMahasiswa()
        mahasiswaRVAdapter = MahasiswaRVAdapter(mahasiswaModalList, this)
        mahasiswaRV = findViewById(R.id.idRVMahasiswa)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mahasiswaRV.layoutManager = linearLayoutManager
        mahasiswaRV.adapter = mahasiswaRVAdapter
    }
}