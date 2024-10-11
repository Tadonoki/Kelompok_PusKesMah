package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pilihdokterjanji : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pilihdokterjanji)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonKonsul1 = findViewById<ImageButton>(R.id.konsultasikembalijanjioffline)

        // Ketika tombol konsultasi kembali ke home di klik, pindah ke HomeActivity
        buttonKonsul1.setOnClickListener {
            val intent = Intent(this@pilihdokterjanji, janjioffline::class.java)
            startActivity(intent)
        }
    }
}