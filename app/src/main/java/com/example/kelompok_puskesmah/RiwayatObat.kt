package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RiwayatObat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Pastikan ini didefinisikan jika kamu menggunakannya
        setContentView(R.layout.activity_riwayat_obat) // Pastikan layout ini ada

        val beranda = findViewById<ImageButton>(R.id.beranda)
        val riwayat = findViewById<ImageButton>(R.id.riwayat)
        val pesan = findViewById<ImageButton>(R.id.pesan)
        val kehome = findViewById<ImageButton>(R.id.kehome)
        val janjioffline = findViewById<Button>(R.id.riwayatoffline)

        janjioffline.setOnClickListener {
            val intent = Intent(this@RiwayatObat, Riwayat::class.java)
            startActivity(intent)
        }

        kehome.setOnClickListener {
            val intent = Intent(this@RiwayatObat, HomeActivity::class.java)
            startActivity(intent)
        }

        beranda.setOnClickListener {
            val intent = Intent(this@RiwayatObat, HomeActivity::class.java)
            startActivity(intent)
        }

        riwayat.setOnClickListener {
            val intent = Intent(this@RiwayatObat, riwayat::class.java)
            startActivity(intent)
        }

        pesan.setOnClickListener {
            val intent = Intent(this@RiwayatObat, Pesan::class.java)
            startActivity(intent)
        }

        val ButtonAkun = findViewById<ImageButton>(R.id.akun)

        // Ketika tombol masuk di klik, pindah ke Akun
        ButtonAkun.setOnClickListener {
            val intent = Intent(this@RiwayatObat, akun::class.java)
            startActivity(intent)
        }
    }
}
