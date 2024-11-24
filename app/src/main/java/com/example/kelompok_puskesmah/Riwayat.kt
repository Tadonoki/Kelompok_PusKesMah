package com.example.kelompok_puskesmah

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Riwayat : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var riwayatAdapter: RiwayatAdapter
    private val riwayatList = mutableListOf<RiwayatData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.rvRiwayat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        riwayatAdapter = RiwayatAdapter(riwayatList)
        recyclerView.adapter = riwayatAdapter

        // Inisialisasi Firebase
        database = FirebaseDatabase.getInstance().getReference("janjiOffline")

        // Membaca data dari Firebase
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                riwayatList.clear()
                for (dataSnapshot in snapshot.children) {
                    val data = dataSnapshot.getValue(RiwayatData::class.java)
                    data?.let { riwayatList.add(it) }
                }
                riwayatAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })

        val kehome = findViewById<ImageButton>(R.id.kehome)
        val beranda = findViewById<ImageButton>(R.id.beranda)
        val riwayat = findViewById<ImageButton>(R.id.riwayat)
        val pesan = findViewById<ImageButton>(R.id.pesan)
        val obat = findViewById<Button>(R.id.obat1)
        val ButtonAkun = findViewById<ImageButton>(R.id.akun)

        // Navigasi ke halaman lain
        obat.setOnClickListener {
            val intent = Intent(this@Riwayat, RiwayatObat::class.java)
            startActivity(intent)
        }

        kehome.setOnClickListener {
            val intent = Intent(this@Riwayat, HomeActivity::class.java)
            startActivity(intent)
        }

        beranda.setOnClickListener {
            val intent = Intent(this@Riwayat, HomeActivity::class.java)
            startActivity(intent)
        }

        riwayat.setOnClickListener {
            val intent = Intent(this@Riwayat, Riwayat::class.java)
            startActivity(intent)
        }

        pesan.setOnClickListener {
            val intent = Intent(this@Riwayat, Pesan::class.java)
            startActivity(intent)
        }

        ButtonAkun.setOnClickListener {
            val intent = Intent(this@Riwayat, akun::class.java)
            startActivity(intent)
        }
    }
}
