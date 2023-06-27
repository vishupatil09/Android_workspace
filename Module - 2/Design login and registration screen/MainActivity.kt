package com.example.formex

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.formex.databinding.ActivityMain2Binding
import com.example.formex.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var edu = arrayOf("Select The Education","(1) Graduated ","(2) Parsing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,edu)
        binding.sp1.adapter= data
        

        binding.bt1.setOnClickListener {

             var builder = StringBuilder("YOur details is :\n ")

            var name  = binding.edt1.text.toString()
            var name1 = binding.edt2.text.toString()
            var name2 = binding.edt2.text.toString()
            var name3 = binding.chk1.text.toString()
            var name4 = binding.chk2.text.toString()
            var name5 = binding.chk3.text.toString()

            builder.append( name,"\n" +name1,"\n" + name2,"\n"+name3,"\n"+ name4,"\n" + name5 )


            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("Form",builder.toString())
            startActivity(i)


        }


    }

    override fun onBackPressed() {
        finishAffinity()
    }
}