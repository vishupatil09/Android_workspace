package com.example.showhidetext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn1 :Button
    lateinit var btn2 :Button
    lateinit var txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt = findViewById(R.id.txt)

        btn1.setOnClickListener {

            txt.visibility = View.GONE
            btn1.visibility = View.GONE
            btn2.visibility = View.VISIBLE
        }
        btn2.setOnClickListener {
            txt.visibility = View.VISIBLE
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.GONE
        }
    }
}