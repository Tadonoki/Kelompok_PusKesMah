package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class konfirmasipembayaranobat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konfirmasipembayaranobat)
        val cekpesanan = findViewById<Button>(R.id.cekpesanan)

        cekpesanan.setOnClickListener {
            val intent = Intent(this@konfirmasipembayaranobat, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}