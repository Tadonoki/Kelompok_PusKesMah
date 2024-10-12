package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin) // Menghubungkan layout activity_signin.xml

        // Cari tombol masuk dengan ID
        val masukButton = findViewById<Button>(R.id.signin) // Pastikan Anda memiliki ID yang benar

        // Ketika tombol masuk di klik, pindah ke HomeActivity
        masukButton.setOnClickListener {
            val intent = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
