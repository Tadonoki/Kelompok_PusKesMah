package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class akun : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private var username: String? = null // Username yang diambil dari SharedPreferences atau intent

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        // Inisialisasi referensi database Firebase
        database = FirebaseDatabase.getInstance().getReference("users")

        // Ambil username dari SharedPreferences (atau cara lain)
        val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
        username = sharedPref.getString("username", null)

        // Inisialisasi TextView untuk menampilkan data
        val tvUsername = findViewById<TextView>(R.id.tvUsername)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)

        // Periksa apakah username tersedia
        if (username != null) {
            // Ambil data pengguna berdasarkan username
            database.child(username!!).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val userEmail = snapshot.child("email").getValue(String::class.java) ?: "Tidak tersedia"
                        val userPassword = snapshot.child("password").getValue(String::class.java) ?: "Tidak tersedia"

                        // Tampilkan data di TextView
                        tvUsername.text = "Username: $username"
                        tvEmail.text = "Email: $userEmail"
                        tvPassword.text = "Password: $userPassword"
                    } else {
                        Toast.makeText(this@akun, "Data pengguna tidak ditemukan.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@akun, "Gagal memuat data: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, "Username tidak ditemukan.", Toast.LENGTH_SHORT).show()
        }

        // Navigasi ke Beranda
        val buttonHome = findViewById<ImageButton>(R.id.beranda)
        buttonHome.setOnClickListener {
            val intent = Intent(this@akun, HomeActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Riwayat
        val riwayatButton = findViewById<ImageButton>(R.id.riwayat)
        riwayatButton.setOnClickListener {
            val intent = Intent(this@akun, Riwayat::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pesan
        val buttonPesan = findViewById<ImageButton>(R.id.pesan)
        buttonPesan.setOnClickListener {
            val intent = Intent(this@akun, Pesan::class.java)
            startActivity(intent)
        }

        // Logout
        val logoutButton = findViewById<Button>(R.id.btnLogout)
        logoutButton.setOnClickListener {
            // Hapus data dari SharedPreferences
            sharedPref.edit().clear().apply()

            // Navigasi ke halaman login
            val intent = Intent(this@akun, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
