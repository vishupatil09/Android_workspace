package com.example.swichscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editNumber1: EditText
    private lateinit var editNumber2: EditText
    private lateinit var btnShowNumbers: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)
        btnShowNumbers = findViewById(R.id.btnShowNumbers)

        btnShowNumbers.setOnClickListener {
            val number1 = editNumber1.text.toString().toInt()
            val number2 = editNumber2.text.toString().toInt()

            val intent = Intent(this@MainActivity, DisplayNumbersActivity::class.java)
            intent.putExtra("number1", number1)
            intent.putExtra("number2", number2)
            startActivity(intent)
        }
    }
}
