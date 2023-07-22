package com.example.mathmatic

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mathmatic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var radioGroup: RadioGroup
    private lateinit var editNumber1: EditText
    private lateinit var editNumber2: EditText
    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        radioGroup = findViewById(R.id.radioGroup)
        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)
        btnCalculate = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)

        btnCalculate.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateResult() {
        val number1 = editNumber1.text.toString().toFloatOrNull() ?: 0f
        val number2 = editNumber2.text.toString().toFloatOrNull() ?: 0f

        val selectedOperation = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

        val result = when (selectedOperation.text) {
            "Add" -> number1 + number2
            "Subtract" -> number1 - number2
            "Multiply" -> number1 * number2
            "Division" -> {
                if (number2 != 0f) {
                    number1 / number2
                } else {
                    0f
                }
            }
            else -> 0f
        }

        textResult.text = "Result: $result"
    }
}
