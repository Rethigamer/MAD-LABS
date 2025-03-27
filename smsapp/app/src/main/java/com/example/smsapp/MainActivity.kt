package com.example.smsapp

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val REQUEST_PERMISSION_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val eTphoneNo : EditText = findViewById(R.id.eTphoneNo)
        val eTmsg : EditText = findViewById(R.id.eTsendMsg)
        val btSend : Button = findViewById(R.id.bTsend)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), REQUEST_PERMISSION_CODE)
        }

        btSend.setOnClickListener {
            val phoneNo = eTphoneNo.text.toString()
            val msg = eTmsg.text.toString()
            val smsManager: SmsManager
            smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNo, null, msg, null, null)
            Toast.makeText(this, "Message has been sent", Toast.LENGTH_LONG).show()
        }
    }
}