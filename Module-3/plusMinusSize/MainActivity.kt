package com.example.sizeplusminus

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.view)

        var btnIncrease: Button = findViewById(R.id.btn1)
        var btnDecrease: Button = findViewById(R.id.btn2)

        btnIncrease.setOnClickListener {
            increaseFontSize()
        }

        btnDecrease.setOnClickListener {
            decreaseFontSize()
        }
    }

    private fun increaseFontSize() {
        val currentSize = textView.textSize / resources.displayMetrics.scaledDensity
        textView.setTextSize(currentSize + 1)
    }

    private fun decreaseFontSize() {
        val currentSize = textView.textSize / resources.displayMetrics.scaledDensity
        textView.setTextSize(currentSize - 1)
    }
}
