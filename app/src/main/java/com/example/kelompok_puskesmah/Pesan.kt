package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pesan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pesan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val detailchat = findViewById<TextView>(R.id.detailchat)

        // Ketika tombol masuk di klik, pindah ke Beranda
        detailchat.setOnClickListener {
            val intent = Intent(this@Pesan, chatdokterkonsultasi::class.java)
            startActivity(intent)
        }


        val arrowleft = findViewById<ImageButton>(R.id.pesankembalihome)

        // Ketika tombol masuk di klik, pindah ke Beranda
        arrowleft.setOnClickListener {
            val intent = Intent(this@Pesan, HomeActivity::class.java)
            startActivity(intent)
        }

        val ButtonHome = findViewById<ImageButton>(R.id.beranda)

        // Ketika tombol masuk di klik, pindah ke Beranda
        ButtonHome.setOnClickListener {
            val intent = Intent(this@Pesan, HomeActivity::class.java)
            startActivity(intent)
        }

        val ButtonAkun = findViewById<ImageButton>(R.id.akun)

        // Ketika tombol masuk di klik, pindah ke Riwayat
        val riwayatButton = findViewById<ImageButton>(R.id.riwayat)
        riwayatButton.setOnClickListener {
            val intent = Intent(this@Pesan, Riwayat::class.java)
            startActivity(intent)
        }

        // Ketika tombol masuk di klik, pindah ke Beranda
        ButtonAkun.setOnClickListener {
            val intent = Intent(this@Pesan, akun::class.java)
            startActivity(intent)
        }
    }
}