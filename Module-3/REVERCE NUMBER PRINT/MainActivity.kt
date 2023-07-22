package com.example.revercenum

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
        lateinit var editText: EditText
        lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          editText = findViewById(R.id.editTextNumber)
          textView = findViewById(R.id.textViewReverse)


        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val input = s?.toString()?.trim()
                if (input.isNullOrEmpty()) {
                    textView.text = ""
                }
                else
                {
                    val reverseNumber = input.reversed()
                    textView.text = "Reverse: $reverseNumber"
                }
            }
        })
    }
}
