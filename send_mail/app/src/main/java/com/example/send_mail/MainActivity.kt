package com.example.send_mail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEmail:EditText = findViewById(R.id.to_mailid)
        val etSubject:EditText = findViewById(R.id.subject_content)
        val etMessage:EditText = findViewById(R.id.message_content)
        val btSend:Button = findViewById(R.id.send)

        btSend.setOnClickListener {
            val email = etEmail.text.toString()
            val sub = etSubject.text.toString()
            val msg = etMessage.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, sub)
            intent.putExtra(Intent.EXTRA_TEXT, msg)

            intent.type="message/rfc822"
            startActivity(Intent.createChooser(intent,"Choose a client: "))
        }

    }
}