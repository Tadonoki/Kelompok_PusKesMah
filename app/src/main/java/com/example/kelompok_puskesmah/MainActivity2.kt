package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2) // Menghubungkan layout activity_main2.xml

        // Cari tombol daftar dengan ID
        val daftarButton = findViewById<Button>(R.id.signup)

        // Ketika tombol daftar di klik, pindah ke HomeActivity
        daftarButton.setOnClickListener {
            val intent = Intent(this@MainActivity2, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
