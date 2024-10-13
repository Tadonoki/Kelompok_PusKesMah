package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class akun : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_akun)

        val ButtonHome = findViewById<ImageButton>(R.id.beranda)

        // Ketika tombol masuk di klik, pindah ke Beranda
        ButtonHome.setOnClickListener {
            val intent = Intent(this@akun, HomeActivity::class.java)
            startActivity(intent)
        }

        val ButtonPesan = findViewById<ImageButton>(R.id.pesan)

        // Ketika tombol masuk di klik, pindah ke Riwayat
        val riwayatButton = findViewById<ImageButton>(R.id.riwayat)
        riwayatButton.setOnClickListener {
            val intent = Intent(this@akun, Riwayat::class.java)
            startActivity(intent)
        }

        // Ketika tombol masuk di klik, pindah ke pesan
        ButtonPesan.setOnClickListener {
            val intent = Intent(this@akun, Pesan::class.java)
            startActivity(intent)
        }
    }
}