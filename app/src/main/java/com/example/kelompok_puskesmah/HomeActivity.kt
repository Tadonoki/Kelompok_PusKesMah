package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
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
    }
}
