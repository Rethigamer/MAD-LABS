package com.example.sdcard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etRegNo = findViewById<EditText>(R.id.edRegNo)
        val etName = findViewById<EditText>(R.id.edName)
        val etcgpa = findViewById<EditText>(R.id.edCGPA)
        val btSave = findViewById<Button>(R.id.btSave)
        val btLoad = findViewById<Button>(R.id.btLoad)

        btSave.setOnClickListener {
            val rollno = etRegNo.text.toString()
            val name = etName.text.toString()
            val cgpa = etcgpa.text.toString()

            val file = File(getExternalFilesDir(null), "students.txt")
            val writer = FileWriter(file)
            writer.write("$rollno\n$name\n$cgpa")
            writer.close()

            Toast.makeText(this,"Saved Successfully",Toast.LENGTH_LONG).show()
        }

        btLoad.setOnClickListener{

            val file = File(getExternalFilesDir(null),"students.txt")
            val reader = BufferedReader(FileReader(file))
            val rollno = reader.readLine()
            val name = reader.readLine()
            val cgpa = reader.readLine()
            etRegNo.setText(rollno)
            etName.setText(name)
            etcgpa.setText(cgpa)

            reader.close()
        }

    }
}