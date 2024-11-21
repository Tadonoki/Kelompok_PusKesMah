package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kelompok_puskesmah.databinding.ActivityPembelianobatBinding  // Menggunakan binding yang benar
import com.google.firebase.database.*

class PembelianObat : AppCompatActivity() {

    private lateinit var binding: ActivityPembelianobatBinding  // Binding yang benar
    private lateinit var database: DatabaseReference
    private lateinit var doctorList: MutableList<Doctor>
    private lateinit var adapter: DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityPembelianobatBinding.inflate(layoutInflater)  // Gunakan binding yang benar
        setContentView(binding.root)

        // Firebase reference
        database = FirebaseDatabase.getInstance().reference

        // Initialize RecyclerView
        doctorList = mutableListOf()  // Menggunakan mutableListOf
        adapter = DoctorAdapter(doctorList) { doctor ->
            saveToHistory(doctor)
        }

        // Setup RecyclerView
        binding.recyclerViewDoctors.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDoctors.adapter = this.adapter

        // Load data from Firebase
        loadDoctors()

        // Add dummy data to Firebase (Create), jika belum ada
        addDummyDoctors()
    }

    // Load data dokter dari Firebase
    private fun loadDoctors() {
        database.child("doctors").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                doctorList.clear()
                for (data in snapshot.children) {
                    val doctor = data.getValue(Doctor::class.java)
                    doctor?.let { doctorList.add(it) }
                }
                adapter.notifyDataSetChanged()  // Menggunakan notifyDataSetChanged dari adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PembelianObat, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Menyimpan dokter ke riwayat
    private fun saveToHistory(doctor: Doctor) {
        database.child("history").push().setValue(doctor)
            .addOnSuccessListener {
                // Menampilkan Toast berhasil dan berpindah ke konfirmasipembayaranobat
                Toast.makeText(this, "Pemesanan sukses", Toast.LENGTH_SHORT).show()

                // Intent berpindah ke halaman konfirmasipembayaranobat
                val intent = Intent(this, konfirmasipembayaranobat::class.java)
                startActivity(intent)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Pemesanan gagal", Toast.LENGTH_SHORT).show()
            }
    }


    // Fungsi untuk menambah data dummy jika belum ada di Firebase
    private fun addDummyDoctors() {
        database.child("doctors").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.exists()) {
                    // Jika node "doctors" kosong, tambahkan data dummy
                    val doctors = listOf(
                        Doctor("Paracetamol", "Rp 10.000/tablet"),
                        Doctor("Promethazine", "Rp 20.000/tablet"),
                        Doctor("Ibuprofen", "Rp 10.000/tablet")
                    )

                    doctors.forEach {
                        database.child("doctors").push().setValue(it)
                    }

                    Toast.makeText(this@PembelianObat, "Dummy data added to Firebase", Toast.LENGTH_SHORT).show()
                } else {
                    // Data sudah ada, tidak menambahkan lagi
                    Toast.makeText(this@PembelianObat, "Pembelian Obat Dokter", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PembelianObat, "Failed to check data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

// Data class untuk Doctor
data class Doctor(val name: String = "", val specialty: String = "")

// Adapter untuk RecyclerView
class DoctorAdapter(
    private val doctorList: MutableList<Doctor>,  // MutableList agar bisa dimodifikasi
    private val onClick: (Doctor) -> Unit
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    inner class DoctorViewHolder(val view: android.view.View) : RecyclerView.ViewHolder(view) {
        fun bind(doctor: Doctor) {
            view.findViewById<android.widget.TextView>(R.id.tvDoctorName).text = doctor.name
            view.findViewById<android.widget.TextView>(R.id.tvDoctorSpecialty).text = doctor.specialty
            view.setOnClickListener { onClick(doctor) }
        }
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): DoctorViewHolder {
        val view = android.view.LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(doctorList[position])
    }

    override fun getItemCount(): Int = doctorList.size
}
