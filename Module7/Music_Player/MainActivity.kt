package com.example.musicplayer


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var img1: ImageView
    lateinit var img2:ImageView
    lateinit var songPlayer: SongPlayer
    lateinit var img3:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1 = findViewById(R.id.i1)
        img2 = findViewById(R.id.i2)
        img3 = findViewById(R.id.i3)
        songPlayer = SongPlayer(this)



        img1.setOnClickListener {
            songPlayer.playSong()

        }

        img3.setOnClickListener {
            songPlayer.nextSong()
            songPlayer.playSong()

        }
        img2.setOnClickListener{

            songPlayer.stopSong()

        }


    }


}