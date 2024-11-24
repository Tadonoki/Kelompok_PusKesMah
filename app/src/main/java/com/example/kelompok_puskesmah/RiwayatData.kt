package com.example.kelompok_puskesmah

data class RiwayatData(
    val poli: String? = null,
    val lokasi: String? = null,
    val jam: String? = null,
    val tanggal: String? = null, // Menambahkan tanggal
    val dokter: String? = null   // Menambahkan dokter
)