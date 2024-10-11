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

class Detaildokter : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detaildokter)
        val buttonKonsul1 = findViewById<ImageButton>(R.id.backtokonsultasi)
        val buttonDokter1 = findViewById<Button>(R.id.chatdokter1)

        // Ketika tombol konsultasi kembali ke home di klik, pindah ke HomeActivity
        buttonKonsul1.setOnClickListener {
            val intent = Intent(this@Detaildokter, konsultasi::class.java)
            startActivity(intent)
        }

        // Ketika tombol detail dokter 1 di klik, pindah ke Detaildokter
        buttonDokter1.setOnClickListener {
            val intent = Intent(this@Detaildokter, chatdokterkonsultasi::class.java)
            startActivity(intent)
        }


    }
}