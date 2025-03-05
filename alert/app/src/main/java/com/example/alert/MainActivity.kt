package com.example.alert

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val msg = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val alert = AlertDialog.Builder(this)
                .setMessage(msg.text.toString())
                .setTitle("MAD Lab")
                .setCancelable(false)
                .setPositiveButton("OK"){
                    dialog, which -> Toast.makeText(this, "You Clicked OK", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel"){
                    dialog, which -> Toast.makeText(this, "You Clicked Cancel", Toast.LENGTH_SHORT).show()
                }
                alert.show()
        }
    }
}