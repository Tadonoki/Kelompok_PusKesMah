package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class konsultasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konsultasi)

        val buttonKonsul = findViewById<ImageButton>(R.id.konsultasikembalihome)
        val buttonDokter1 = findViewById<Button>(R.id.detaildokter1)

        // Ketika tombol konsultasi kembali ke home di klik, pindah ke HomeActivity
        buttonKonsul.setOnClickListener {
            val intent = Intent(this@konsultasi, HomeActivity::class.java)
            startActivity(intent)
        }

        // Ketika tombol detail dokter 1 di klik, pindah ke Detaildokter
        buttonDokter1.setOnClickListener {
            val intent = Intent(this@konsultasi, Detaildokter::class.java)
            startActivity(intent)
        }
    }
}
