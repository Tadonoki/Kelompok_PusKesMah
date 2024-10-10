package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class janjioffline : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_janjioffline) // Pastikan layout ini memiliki Spinner

        val buttonJanji = findViewById<ImageButton>(R.id.janjiofflinekehome)

        // Ketika tombol konsultasi kembali ke home di klik, pindah ke HomeActivity
        buttonJanji.setOnClickListener {
            val intent = Intent(this@janjioffline, HomeActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi Spinner
        val spinner: Spinner = findViewById(R.id.spinner) // Pastikan ID ini sesuai dengan layout activity_janjioffline

        // Data untuk dropdown
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")

        // Adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapter ke Spinner
        spinner.adapter = adapter
    }
}
