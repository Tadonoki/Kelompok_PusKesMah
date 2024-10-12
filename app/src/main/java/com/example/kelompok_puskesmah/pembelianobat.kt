package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pembelianobat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pembelianobat)
        val buttonKonsul = findViewById<ImageButton>(R.id.backtochatdokter)
        val buttonbeliobat = findViewById<Button>(R.id.beliobat)

        buttonKonsul.setOnClickListener {
            val intent = Intent(this@pembelianobat, chatdokterkonsultasi::class.java)
            startActivity(intent)
        }

        buttonbeliobat.setOnClickListener {
            val intent = Intent(this@pembelianobat, konfirmasipembayaranobat::class.java)
            startActivity(intent)
        }
    }
}