package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // Menghubungkan layout activity_home.xml
        // Cari tombol masuk dengan ID
        val masukButton = findViewById<ImageButton>(R.id.buatjanjioflline) // Pastikan Anda memiliki ID yang benar

        // Ketika tombol masuk di klik, pindah ke janji Offline
        masukButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        val ButtonKonsul = findViewById<ImageButton>(R.id.konsultasi)

        // Ketika tombol masuk di klik, pindah ke Konsultasi
        ButtonKonsul.setOnClickListener {
            val intent = Intent(this@HomeActivity, konsultasi::class.java)
            startActivity(intent)
        }


        val ButtonAkun = findViewById<ImageButton>(R.id.akun)

        // Ketika tombol masuk di klik, pindah ke Akun
        ButtonAkun.setOnClickListener {
            val intent = Intent(this@HomeActivity, akun::class.java)
            startActivity(intent)
        }

        val ButtonPesan = findViewById<ImageButton>(R.id.pesan)

        // Ketika tombol masuk di klik, pindah ke Riwayat
        val riwayatButton = findViewById<ImageButton>(R.id.riwayat)
        riwayatButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, Riwayat::class.java)
            startActivity(intent)
        }
        // Ketika tombol masuk di klik, pindah ke Akun
        ButtonPesan.setOnClickListener {
            val intent = Intent(this@HomeActivity, Pesan::class.java)
            startActivity(intent)
        }
    }
}
