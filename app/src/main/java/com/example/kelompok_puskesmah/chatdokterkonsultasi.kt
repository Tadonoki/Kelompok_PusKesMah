package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton

class chatdokterkonsultasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chatdokterkonsultasi)
        val buttonKonsul = findViewById<ImageButton>(R.id.backtodetaildokter)
        val buttonobat = findViewById<Button>(R.id.beliobat)

        buttonKonsul.setOnClickListener {
            val intent = Intent(this@chatdokterkonsultasi, Detaildokter::class.java)
            startActivity(intent)
        }
        buttonobat.setOnClickListener{
            val intent = Intent(this@chatdokterkonsultasi, pembelianobat::class.java)
            startActivity(intent)
        }
    }
}
