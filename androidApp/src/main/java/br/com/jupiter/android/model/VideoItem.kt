package br.com.jupiter.android.model

import android.net.Uri
import androidx.media3.common.MediaItem


data class VideoItem(
    val contentUri: Uri,
    val mediaItem: MediaItem
    )
