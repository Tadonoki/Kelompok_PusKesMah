package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SignInActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin) // Menghubungkan layout activity_signin.xml

        // Inisialisasi komponen UI
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        // Inisialisasi referensi database Firebase
        database = FirebaseDatabase.getInstance().getReference("users")

        // Tombol Register -> Navigasi ke MainActivity2
        btnRegister.setOnClickListener {
            val intent = Intent(this@SignInActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        // Tombol Login -> Validasi login dengan Firebase
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                database.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.child(username).exists()) {
                            val storedPassword = snapshot.child(username).child("password").getValue(String::class.java)
                            if (storedPassword == password) {
                                Toast.makeText(this@SignInActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()
                                val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                                startActivity(homeIntent)
                            } else {
                                Toast.makeText(this@SignInActivity, "Password salah", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@SignInActivity, "Data belum terdaftar", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@SignInActivity, "Terjadi kesalahan: ${error.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}
