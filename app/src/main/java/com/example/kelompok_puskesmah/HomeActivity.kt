package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var tvTime: TextView
    private val handler = Handler()
    private lateinit var runnable: Runnable

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inisialisasi TextView untuk waktu real-time
        tvTime = findViewById(R.id.tvTime)

        // Logika untuk memperbarui waktu secara real-time
        runnable = object : Runnable {
            override fun run() {
                val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
                tvTime.text = currentTime
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)

        // Mengambil username dari SharedPreferences
        val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
        val username = sharedPref.getString("username", null)

        // Tombol buat janji offline
        val masukButton = findViewById<ImageButton>(R.id.buatjanjioflline)
        masukButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol konsultasi
        val ButtonKonsul = findViewById<ImageButton>(R.id.konsultasi)
        ButtonKonsul.setOnClickListener {
            val intent = Intent(this@HomeActivity, konsultasi::class.java)
            startActivity(intent)
        }

        // Tombol poli umum
        val poliumum = findViewById<ImageButton>(R.id.poliumum)
        poliumum.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol poli gigi
        val poligigi = findViewById<ImageButton>(R.id.poligigi)
        poligigi.setOnClickListener {
            val intent = Intent(this@HomeActivity, notfound404::class.java)
            startActivity(intent)
        }

        // Tombol layanan gawat
        val layanangawat = findViewById<ImageButton>(R.id.layanangawat)
        layanangawat.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol layanan psikologi
        val layananpsikologi = findViewById<ImageButton>(R.id.layananpsikologi)
        layananpsikologi.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol layanan lab
        val layananlab = findViewById<ImageButton>(R.id.layananlab)
        layananlab.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol layanan radiologi
        val layananradiologi = findViewById<ImageButton>(R.id.layananradiologi)
        layananradiologi.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol layanan surat
        val layanansurat = findViewById<ImageButton>(R.id.layanansurat)
        layanansurat.setOnClickListener {
            val intent = Intent(this@HomeActivity, janjioffline::class.java)
            startActivity(intent)
        }

        // Tombol akun
        val ButtonAkun = findViewById<ImageButton>(R.id.akun)
        ButtonAkun.setOnClickListener {
            // Kirim username ke activity akun
            val intent = Intent(this@HomeActivity, akun::class.java)
            intent.putExtra("username", username) // Menambahkan data username
            startActivity(intent)
        }

        // Tombol pesan
        val ButtonPesan = findViewById<ImageButton>(R.id.pesan)
        ButtonPesan.setOnClickListener {
            val intent = Intent(this@HomeActivity, Pesan::class.java)
            startActivity(intent)
        }

        // Tombol riwayat
        val riwayatButton = findViewById<ImageButton>(R.id.riwayat)
        riwayatButton.setOnClickListener {
            val intent = Intent(this@HomeActivity, Riwayat::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable) // Hentikan pembaruan waktu saat activity dihancurkan
    }
}
