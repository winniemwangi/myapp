package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.LineHeightSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMICalculatorActivity : AppCompatActivity() {
    lateinit var btnSend: Button
    lateinit var btnCalculate: Button
    lateinit var etWeight: EditText
    lateinit var etHeight: EditText
    lateinit var tvResult : TextView
    lateinit var tvBmi : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)
        btnSend = findViewById(R.id.btnSend)
        btnCalculate = findViewById(R.id.btnCalculate)
        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        tvBmi = findViewById(R.id.tvBmi)

        btnSend.setOnClickListener {
            val intent = Intent(this, sendmoney::class.java)
            startActivity(intent)

        }

        btnCalculate.setOnClickListener {
            var weight = etWeight.text.toString()
            var height = etHeight.text.toString()

            if (weight.isBlank()){
                etWeight.error = "Weight is required"
                return@setOnClickListener
            }

            if (height.isBlank()){

                etHeight.error = "Height is required"
                return@setOnClickListener
            }

            calculateBMI(weight.toDouble(), height.toInt())

        }
    }


    fun calculateBMI(weight: Double, height: Int){
        var heightMeter = height/100.0
        var bmi = weight/(heightMeter*heightMeter)
        tvResult.text = bmi.toString()

        if(bmi<18.5){
           tvBmi.text= "Underweight"
        }
        else if(bmi > 18.5 && bmi < 24.9) {
           tvBmi.text = "Normal"
        }
        else if(bmi > 24.9 && bmi < 30) {
            tvBmi.text = "Overweight"
        }
        else {
            tvBmi.text = "Obese"
        }

    }

}
