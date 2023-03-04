package br.com.jupiter.android.model

import android.content.Context
import androidx.media3.exoplayer.ExoPlayer

object VideoPlayerFactory {
    fun videoPlayer(context: Context) = ExoPlayer.Builder(context).build()
}