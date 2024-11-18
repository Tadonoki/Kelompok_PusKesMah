
package com.example.kelompok_puskesmah


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kelompok_puskesmah.MainActivity2
import com.example.kelompok_puskesmah.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Menghubungkan dengan layout activity_main.xml

        // Cari tombol daftar dengan ID
        val daftarButton = findViewById<Button>(R.id.daftar)

        // Ketika tombol daftar di klik, pindah ke MainActivity2
        daftarButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
        val loginButton = findViewById<Button>(R.id.login)

        // Ketika tombol daftar di klik, pindah ke MainActivity2
        loginButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
