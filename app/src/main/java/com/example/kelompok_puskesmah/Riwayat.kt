package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Riwayat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Pastikan ini didefinisikan jika kamu menggunakannya
        setContentView(R.layout.activity_riwayat) // Pastikan layout ini ada

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ButtonHome = findViewById<ImageButton>(R.id.beranda)


//        val ButtonPesan = findViewById<ImageButton>(R.id.pesan)

        // Ketika tombol masuk di klik, pindah ke Beranda
        ButtonHome.setOnClickListener {
            val intent = Intent(this@Riwayat, HomeActivity::class.java)
            startActivity(intent)
        }

        val ButtonAkun = findViewById<ImageButton>(R.id.akun)

        // Ketika tombol masuk di klik, pindah ke Riwayat
        val riwayatButton = findViewById<ImageButton>(R.id.riwayat)
        riwayatButton.setOnClickListener {
            val intent = Intent(this@Riwayat, Riwayat::class.java)
            startActivity(intent)
        }


//        // Ketika tombol masuk di klik, pindah ke Akun
//        ButtonPesan.setOnClickListener {
//            val intent = Intent(this@Riwayat, Pesan::class.java)
//            startActivity(intent)
//        }



        // Ketika tombol masuk di klik, pindah ke Akun
        ButtonAkun.setOnClickListener {
            val intent = Intent(this@Riwayat, akun::class.java)
            startActivity(intent)
        }


    }



    companion object {
        fun setOnClickListener(view: View, function: () -> Unit) {
            view.setOnClickListener { function() }
        }
    }
}

