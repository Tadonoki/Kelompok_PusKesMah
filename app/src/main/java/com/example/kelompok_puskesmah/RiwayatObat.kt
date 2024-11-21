package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kelompok_puskesmah.databinding.ActivityRiwayatObatBinding
import com.google.firebase.database.*

class RiwayatObat : AppCompatActivity() {

    private lateinit var binding: ActivityRiwayatObatBinding
    private lateinit var database: DatabaseReference
    private lateinit var historyList: MutableList<Doctor>
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityRiwayatObatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Firebase reference
        database = FirebaseDatabase.getInstance().reference.child("history")

        // Initialize RecyclerView
        historyList = mutableListOf()
        adapter = HistoryAdapter(historyList)

        // Setup RecyclerView
        binding.recyclerViewHistory.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewHistory.adapter = this.adapter

        // Load history data from Firebase
        loadHistory()

        // Button to go back
        binding.riwayatoffline.setOnClickListener {
            onBackPressed()
        }

        // Tambahkan logic tombol
        val beranda = findViewById<ImageButton>(R.id.beranda)
        val riwayat = findViewById<ImageButton>(R.id.riwayat)
        val pesan = findViewById<ImageButton>(R.id.pesan)
        val kehome = findViewById<ImageButton>(R.id.kehome)
        val riwayatoffline = findViewById<Button>(R.id.riwayatoffline)
        val buttonAkun = findViewById<ImageButton>(R.id.akun)

        riwayatoffline.setOnClickListener {
            val intent = Intent(this@RiwayatObat, Riwayat::class.java)
            startActivity(intent)
        }

        kehome.setOnClickListener {
            val intent = Intent(this@RiwayatObat, HomeActivity::class.java)
            startActivity(intent)
        }

        beranda.setOnClickListener {
            val intent = Intent(this@RiwayatObat, HomeActivity::class.java)
            startActivity(intent)
        }

        riwayat.setOnClickListener {
            val intent = Intent(this@RiwayatObat, RiwayatObat::class.java) // Perhatikan nama kelas RiwayatActivity
            startActivity(intent)
        }

        pesan.setOnClickListener {
            val intent = Intent(this@RiwayatObat, Pesan::class.java)
            startActivity(intent)
        }

        buttonAkun.setOnClickListener {
            val intent = Intent(this@RiwayatObat, akun::class.java)
            startActivity(intent)
        }
    }

    // Load data riwayat dari Firebase
    private fun loadHistory() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                historyList.clear()
                for (data in snapshot.children) {
                    val doctor = data.getValue(Doctor::class.java)
                    doctor?.let { historyList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error here
            }
        })
    }
}
