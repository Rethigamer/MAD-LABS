package com.example.exp2

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkin = findViewById<Button>(R.id.checkin)
        val checkout = findViewById<Button>(R.id.checkout)
        val count = findViewById<TextView>(R.id.count)

        checkin.setOnClickListener {
            count.text = (count.text.toString().toInt() + 1).toString()
        }

        checkout.setOnClickListener {
            count.text = (count.text.toString().toInt() - 1).toString()
        }

    }
}