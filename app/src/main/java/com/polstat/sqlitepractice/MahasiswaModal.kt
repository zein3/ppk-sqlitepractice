package com.polstat.sqlitepractice

data class MahasiswaModal(
    val nim: String,
    val nama: String,
    val kelas: String,
    val nohp: String,
    val id: Int? = null
)