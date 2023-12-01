package com.example.apexfurniture.activity

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.apexfurniture.R

class SplashActivity : AppCompatActivity() {

    lateinit var backgroundView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {

            startActivity(Intent(applicationContext, LoginActivity::class.java))

        },2000)
        backgroundView = findViewById(R.id.backgroundView)

//        val colorAnim = ObjectAnimator.ofInt(
//            backgroundView,
//            "backgroundColor",
//            Color.RED, Color.GREEN, Color.BLUE
//        )
//        colorAnim.setEvaluator(ArgbEvaluator())
//        colorAnim.duration = 1000 // Duration in milliseconds
//
//        colorAnim.repeatMode = ObjectAnimator.REVERSE
//        colorAnim.repeatCount = ObjectAnimator.INFINITE
//        colorAnim.start()

    }


    override fun onBackPressed()
    {
        finishAffinity()
    }
}