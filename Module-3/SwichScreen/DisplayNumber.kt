package com.example.swichscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DisplayNumbersActivity : AppCompatActivity() {
    private lateinit var textNumbers: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_number)

        textNumbers = findViewById(R.id.textNumbers)

        val number1 = intent.getIntExtra("number1", 0)
        val number2 = intent.getIntExtra("number2", 0)

        val numbersList = mutableListOf<Int>()
        for (i in number1 + 1 until number2) {
            numbersList.add(i)
        }

        val numbersString = numbersList.joinToString(", ")
        textNumbers.text = "Numbers between $number1 and $number2: $numbersString"
    }
}
