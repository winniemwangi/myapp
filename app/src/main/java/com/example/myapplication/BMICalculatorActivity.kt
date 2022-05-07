package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BMICalculatorActivity : AppCompatActivity() {
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)
        btnSend = findViewById(R.id.btnSend)
        btnSend.setOnClickListener {
            val intent = Intent(this, sendmoney::class.java)
            startActivity(intent)
        }
    }
}