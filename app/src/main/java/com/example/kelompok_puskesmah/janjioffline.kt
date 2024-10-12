package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
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
    private var isJam09Pressed = false// Variabel untuk melacak status tombol
    private var isJam11Pressed = false
    private var isJam13Pressed = false
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

        val buttonlanjutJanji = findViewById<Button>(R.id.lanjutjanjioffline)

        // Ketika tombol konsultasi kembali ke home di klik, pindah ke HomeActivity
        buttonlanjutJanji.setOnClickListener {
            val intent = Intent(this@janjioffline, pilihdokterjanji::class.java)
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
        val items = arrayOf("Poli Umum", "Poli Gigi dan Mulut", "Layanan Gawat Darurat","Layanan Psikologi","Layanan Laboratorium","Layanan Radiologi","Layanan Surat Keterangan Sehat")

        // Adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapter ke Spinner
        spinner.adapter = adapter


        val jam09: Button = findViewById(R.id.jam09)
        jam09.setOnClickListener {
            isJam09Pressed = !isJam09Pressed // Toggle status tombol

            if (isJam09Pressed) {
                // Jika tombol ditekan, ubah warna latar belakang
                jam09.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#82C1FF")) // Warna saat ditekan
            } else {
                // Jika tombol ditekan lagi, kembalikan ke warna awal
                jam09.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF")) // Warna awal
            }
        }


        val jam11: Button = findViewById(R.id.jam11)
        jam11.setOnClickListener {
            isJam11Pressed = !isJam11Pressed // Toggle status tombol

            if (isJam11Pressed) {
                // Jika tombol ditekan, ubah warna latar belakang
                jam11.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#82C1FF")) // Warna saat ditekan
            } else {
                // Jika tombol ditekan lagi, kembalikan ke warna awal
                jam11.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF")) // Warna awal
            }
        }

        val jam13: Button = findViewById(R.id.jam13)
        jam13.setOnClickListener {
            isJam13Pressed = !isJam13Pressed // Toggle status tombol

            if (isJam13Pressed) {
                // Jika tombol ditekan, ubah warna latar belakang
                jam13.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#82C1FF")) // Warna saat ditekan
            } else {
                // Jika tombol ditekan lagi, kembalikan ke warna awal
                jam13.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF")) // Warna awal
            }
        }



    }
}
