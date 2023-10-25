package com.example.musicplayer

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class SongPlayer(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null
    private val songIds = listOf(R.raw.ring1, R.raw.ring2,R.raw.ring3, R.raw.ring4, R.raw.ring5, R.raw.ring6, R.raw.ring7, R.raw.ring8, R.raw.ring9, R.raw.ring10)
    private var currentSongIndex = 0

    fun playSong() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, songIds[currentSongIndex])
        }

        mediaPlayer?.start()
    }

    fun stopSong() {
        mediaPlayer!!.pause()
    }

    fun nextSong() {
        if (mediaPlayer != null) {
            mediaPlayer?.release()
            mediaPlayer = null
        }

        currentSongIndex = (currentSongIndex + 1) % songIds.size
    }

}
