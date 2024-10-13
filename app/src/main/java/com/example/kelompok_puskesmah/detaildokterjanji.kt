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

class detaildokterjanji : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detaildokterjanji)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonKonsul1 = findViewById<ImageButton>(R.id.detaildokterkembali)


        buttonKonsul1.setOnClickListener {
            val intent = Intent(this@detaildokterjanji, pilihdokterjanji::class.java)
            startActivity(intent)
        }

        val konfirmasijanji = findViewById<Button>(R.id.konfirmasijanji)

        konfirmasijanji.setOnClickListener {
            val intent = Intent(this@detaildokterjanji, Riwayat::class.java)
            startActivity(intent)
        }

    }
}