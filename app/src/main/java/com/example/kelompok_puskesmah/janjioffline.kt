package com.example.kelompok_puskesmah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class janjioffline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_janjioffline) // Pastikan layout ini memiliki Spinner

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
