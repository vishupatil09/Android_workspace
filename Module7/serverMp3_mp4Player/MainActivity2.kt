package com.example.serverplayer

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity2 : AppCompatActivity() {


    private var mediaPlayer = MediaPlayer()
    lateinit var songTitleTextView :TextView
    lateinit var playButton : Button
    lateinit var pauseButton : Button
    lateinit var stopButton : Button
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var skipButton : Button
    var currentSongIndex =0
    val songUrls = arrayOf(
        "https://immitigable-weeks.000webhostapp.com/API/song/devana.mp3",
        "https://immitigable-weeks.000webhostapp.com/API/song/shammastani.mp3",
        // Add more song URLs as needed
    )

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        mediaPlayer = MediaPlayer()
        initializeMediaPlayer()


        playButton = findViewById(R.id.playButton)
        pauseButton = findViewById(R.id.pauseButton)
        stopButton = findViewById(R.id.stopButton)
        skipButton = findViewById(R.id.skipButton)
        songTitleTextView = findViewById(R.id.songTitleTextView)
        btn1= findViewById(R.id.btn1)
        btn2= findViewById(R.id.btn2)


        btn1.setOnClickListener {
            val wifi = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = true
        }
        btn2.setOnClickListener {
            val wifi = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = false
        }


        playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                val songUrl = songUrls[currentSongIndex]
                try {
                    mediaPlayer.reset()
                    mediaPlayer.setDataSource(songUrl)
                    mediaPlayer.setAudioAttributes(AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                    )
                    mediaPlayer.prepare()
                    mediaPlayer.start()
                    songTitleTextView.text = "Song ${currentSongIndex + 1}"
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()

            }
            else {
                mediaPlayer.release()
            }
        }

        stopButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()
            }        }

        mediaPlayer.setOnCompletionListener {
            currentSongIndex++
            if (currentSongIndex >= songUrls.size) {
                currentSongIndex = 0
            }
            playButton.performClick()
        }
        skipButton.setOnClickListener {
            //currentSongIndex++
            Toast.makeText(applicationContext,"before : "+currentSongIndex,Toast.LENGTH_LONG).show()
            if (currentSongIndex ==0)
            {
                Toast.makeText(applicationContext,"after : "+currentSongIndex,Toast.LENGTH_LONG).show()
                mediaPlayer.stop()

                currentSongIndex+=1


            }
        }


    }
    private fun initializeMediaPlayer() {
        try {
            mediaPlayer.setDataSource(songUrls[currentSongIndex])
            mediaPlayer.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

}
