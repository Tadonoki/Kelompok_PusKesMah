package com.example.kelompok_puskesmah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class notfound404 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notfound404)

        // Find the "Back to Home" button by its ID
        val backToHomeButton = findViewById<Button>(R.id.btnRetry)

        // Set an onClickListener on the button
        backToHomeButton.setOnClickListener {
            // Start HomeActivity when button is clicked
            val intent = Intent(this@notfound404, HomeActivity::class.java)
            startActivity(intent)
            finish() // Optional: Call finish() if you want to close the 404 activity
        }
    }
}
