package com.example.serverplayer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PowerManager
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private var wakeLock: PowerManager.WakeLock? = null
    lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.video)
        button = findViewById(R.id.btn)


        button.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }
        // Acquire a WakeLock to keep the screen on
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(
            PowerManager.FULL_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "VideoPlayerActivity:WakeLock"
        )
        wakeLock?.acquire()

        // Set the video file path
        val videoPath = "https://immitigable-weeks.000webhostapp.com/API/song/dance.mp4"


        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Set the video URI
        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)


        videoView.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        wakeLock?.release()
    }
}
