package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2) // Menghubungkan layout activity_main2.xml

        // Inisialisasi komponen UI
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        // Inisialisasi referensi database Firebase
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://kelompok-puskesmah1-default-rtdb.firebaseio.com/")

        // Event handler untuk tombol register
        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Validasi input kosong
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show()
            } else {
                // Menyimpan data pengguna ke database Firebase
                database = FirebaseDatabase.getInstance().getReference("users")
                database.child(username).child("username").setValue(username)
                database.child(username).child("email").setValue(email)
                database.child(username).child("password").setValue(password)


                // Menampilkan pesan dan navigasi ke halaman login
                Toast.makeText(applicationContext, "Register Berhasil", Toast.LENGTH_SHORT).show()
                val registerIntent = Intent(applicationContext, SignInActivity::class.java)
                intent.putExtra("email", email)  // Menambahkan data email
                startActivity(registerIntent)
            }
        }
    }
}
