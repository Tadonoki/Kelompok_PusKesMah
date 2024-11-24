package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class pilihdokterjanji : AppCompatActivity() {

    // Inisialisasi Firebase Database Reference
    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pilihdokterjanji)

        // Referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference("janjiOffline")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonKonsul1 = findViewById<ImageButton>(R.id.pilihkembalijanjioffline)

        // Tombol kembali ke layout janjioffline
        buttonKonsul1.setOnClickListener {
            val intent = Intent(this@pilihdokterjanji, janjioffline::class.java)
            startActivity(intent)
        }

        val buttonAnastasya = findViewById<Button>(R.id.AnastasyaAmanda)
        buttonAnastasya.setOnClickListener {
            saveDoctorSelection("Anastasya Amanda")
            val intent = Intent(this@pilihdokterjanji, detaildokterjanji::class.java)
            startActivity(intent)
        }

        val buttonRahmat = findViewById<Button>(R.id.RahmatMaulana)
        buttonRahmat.setOnClickListener {
            saveDoctorSelection("Rahmat Maulana")
            val intent = Intent(this@pilihdokterjanji, detaildokterjanji::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk menyimpan pilihan dokter ke Firebase
    private fun saveDoctorSelection(dokterName: String) {
        // Ambil data janji yang sudah ada sebelumnya
        val selectedPoli = intent.getStringExtra("selectedPoli") ?: ""
        val selectedLokasi = intent.getStringExtra("selectedLokasi") ?: ""
        val selectedTime = intent.getStringExtra("selectedTime") ?: ""
        val selectedTanggal = intent.getStringExtra("selectedTanggal") ?: ""

        // Membuat data janji termasuk dokter
        val janjiData = mapOf(
            "poli" to selectedPoli,
            "lokasi" to selectedLokasi,
            "jam" to selectedTime,
            "tanggal" to selectedTanggal,
            "dokter" to dokterName
        )

        // Menambahkan data janji ke Firebase
        val lastJanjiRef = database.push().key // Dapatkan ID unik janji sebelumnya
        if (lastJanjiRef != null) {
            database.child(lastJanjiRef).setValue(janjiData)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Pilihan dokter tersimpan", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Gagal menyimpan data dokter", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Data janji tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }
}
