package com.example.exp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.convert)
        val editText = findViewById<EditText>(R.id.celsius)
        val faren = findViewById<TextView>(R.id.fahrenheit)

        button.setOnClickListener {

            val inputText = editText.text.toString()
            faren.text = ((inputText.toDouble() * 1.8) + 32).toString()
        }

    }
}