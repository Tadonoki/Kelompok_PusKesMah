package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class janjioffline : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private var isJam09Pressed = false
    private var isJam11Pressed = false
    private var isJam13Pressed = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_janjioffline)

        // Inisialisasi Firebase
        database = FirebaseDatabase.getInstance().reference

        val buttonJanji = findViewById<ImageButton>(R.id.janjiofflinekehome)
        buttonJanji.setOnClickListener {
            val intent = Intent(this@janjioffline, HomeActivity::class.java)
            startActivity(intent)
        }

        val buttonlanjutJanji = findViewById<Button>(R.id.lanjutjanjioffline)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi Spinner untuk Poli
        val spinner: Spinner = findViewById(R.id.spinner)
        val items = arrayOf(
            "Poli Umum", "Poli Gigi dan Mulut", "Layanan Gawat Darurat",
            "Layanan Psikologi", "Layanan Laboratorium", "Layanan Radiologi",
            "Layanan Surat Keterangan Sehat"
        )
        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as TextView).setTextColor(Color.BLACK)
                return view
            }
        }
        spinner.adapter = adapter

        // Inisialisasi Spinner untuk Lokasi
        val lokasiSpinner: Spinner = findViewById(R.id.lokasi)
        val lokasiOptions = arrayOf("Klinik UNSRI")
        val adapter1 = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lokasiOptions) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                (view as TextView).setTextColor(Color.BLACK)
                return view
            }
        }
        lokasiSpinner.adapter = adapter1

        val tanggal = findViewById<EditText>(R.id.tanggal)
        val bulan = findViewById<EditText>(R.id.bulan)
        val tahun = findViewById<EditText>(R.id.tahun)


        // Tombol Pilihan Jam
        val jam09: Button = findViewById(R.id.jam09)
        val jam11: Button = findViewById(R.id.jam11)
        val jam13: Button = findViewById(R.id.jam13)

        jam09.setOnClickListener {
            isJam09Pressed = !isJam09Pressed
            jam09.backgroundTintList = ColorStateList.valueOf(
                if (isJam09Pressed) Color.parseColor("#82C1FF") else Color.parseColor("#FFFFFF")
            )
        }

        jam11.setOnClickListener {
            isJam11Pressed = !isJam11Pressed
            jam11.backgroundTintList = ColorStateList.valueOf(
                if (isJam11Pressed) Color.parseColor("#82C1FF") else Color.parseColor("#FFFFFF")
            )
        }

        jam13.setOnClickListener {
            isJam13Pressed = !isJam13Pressed
            jam13.backgroundTintList = ColorStateList.valueOf(
                if (isJam13Pressed) Color.parseColor("#82C1FF") else Color.parseColor("#FFFFFF")
            )
        }

        // Tombol Lanjut Janji
        buttonlanjutJanji.setOnClickListener {
            val selectedPoli = spinner.selectedItem.toString()
            val selectedLokasi = lokasiSpinner.selectedItem.toString()
            val selectedTime = when {
                isJam09Pressed -> "09:00"
                isJam11Pressed -> "11:00"
                isJam13Pressed -> "13:30"
                else -> "Belum Dipilih"
            }

            val selectedTanggal = "${tanggal.text}-${bulan.text}-${tahun.text}"

            // Validasi input
            if (selectedPoli.isEmpty() || selectedLokasi.isEmpty() || selectedTime == "Belum Dipilih" ||
                selectedTanggal.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi semua data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Kirim data ke PilihDokterJanji
            val intent = Intent(this@janjioffline, pilihdokterjanji::class.java)
            intent.putExtra("selectedPoli", selectedPoli)
            intent.putExtra("selectedLokasi", selectedLokasi)
            intent.putExtra("selectedTime", selectedTime)
            intent.putExtra("selectedTanggal", selectedTanggal)
            startActivity(intent)
        }
    }
}
