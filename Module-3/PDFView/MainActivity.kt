package com.example.pdfview


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val btnViewFile: Button = findViewById(R.id.btnViewFile)

        btnViewFile.setOnClickListener {
            val assetManager = assets
            val inputStream = assetManager.open("example.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))

            val stringBuilder = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }

            reader.close()
            textView.text = stringBuilder.toString()
        }
    }
}
