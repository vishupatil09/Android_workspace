package com.example.animation

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity()
{
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView
    lateinit var animationDrawable: AnimationDrawable
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn= findViewById(R.id.btn)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        imageView = findViewById(R.id.img)
        imageView2 = findViewById(R.id.img2)
        animationDrawable=(imageView2.getBackground() as AnimationDrawable)

        animationDrawable.start()

        btn1.setOnClickListener {

            var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
            imageView.startAnimation(anim)
        }
        btn2.setOnClickListener {

            var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate)
            imageView.startAnimation(anim)
        }
        btn3.setOnClickListener {

            var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.fade)
            imageView.startAnimation(anim)
        }
        btn4.setOnClickListener {

            var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.move)
            imageView.startAnimation(anim)
        }
        btn5.setOnClickListener {

            var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.slide)
            imageView.startAnimation(anim)
        }
        btn6.setOnClickListener {

            var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom)
            imageView.startAnimation(anim)
        }
        btn.setOnClickListener {
            imageView.clearAnimation()
        }

    }


}