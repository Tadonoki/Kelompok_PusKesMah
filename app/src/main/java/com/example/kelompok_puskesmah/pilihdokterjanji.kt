package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pilihdokterjanji : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pilihdokterjanji)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonKonsul1 = findViewById<ImageButton>(R.id.pilihkembalijanjioffline)

        // Ketika tombol konsultasi kembali ke home di klik, pindah ke HomeActivity
        buttonKonsul1.setOnClickListener {
            val intent = Intent(this@pilihdokterjanji, janjioffline::class.java)
            startActivity(intent)
        }

        val buttonAnastasya = findViewById<Button>(R.id.AnastasyaAmanda)

        buttonAnastasya.setOnClickListener {
            val intent = Intent(this@pilihdokterjanji, detaildokterjanji::class.java)
            startActivity(intent)
        }
    }
}