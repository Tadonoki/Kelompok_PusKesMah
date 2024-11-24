package com.example.kelompok_puskesmah

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class akun : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private var username: String? = null // Username yang diambil dari SharedPreferences atau intent
    private var email: String? = null // Username yang diambil dari SharedPreferences atau intent



    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)


        // Ambil username dari Intent yang diterima dan simpan dalam variabel kelas
        username = intent.getStringExtra("username")

        intent.putExtra("email", email)  // Menambahkan data email

        // Referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference("users")

        // Menampilkan username di TextView
        val textViewUsername = findViewById<TextView>(R.id.etUsername)
        textViewUsername.text = username ?: "Username tidak ditemukan"

//
// Ambil data dari Firebase dan tampilkan
        if (username != null) {
            database.child(username!!).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Mengambil password dari Firebase
                    val storedPassword = snapshot.child("password").getValue(String::class.java)

                    // Mengambil email dari Firebase
                    val email = snapshot.child("email").getValue(String::class.java)

                    // Menampilkan email di TextView
                    val textViewEmail = findViewById<TextView>(R.id.tvEmail)
                    textViewEmail.text = email ?: "Email tidak ditemukan"

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@akun, "Gagal mengambil data: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, "Username tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
//
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
            val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            // Navigasi ke halaman login
            val intent = Intent(this@akun, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
