package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class konsultasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konsultasi)

        val ButtonKonsul = findViewById<ImageButton>(R.id.konsultasikembalihome)

        // Ketika tombol masuk di klik, pindah ke Konsultasi
        ButtonKonsul.setOnClickListener {
            val intent = Intent(this@konsultasi, HomeActivity::class.java)
            startActivity(intent)
        }
        }
    }
