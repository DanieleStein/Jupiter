package br.com.jupiter.android.model

import android.content.Context
import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class VideoViewModel(
    private val savedState: SavedStateHandle
) : ViewModel() {

    private var _player: Player? = null
    val player: Player? get() = _player

    private val videoUris = savedState.getStateFlow(VIDEO_URIS_KEY, emptyList<Uri>())

    val videoItems = videoUris.map { uris ->
        uris.map {
            VideoItem(
                it,
                MediaItem.fromUri(it),
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addVideoUri(uri: Uri) {
        savedState[VIDEO_URIS_KEY] = videoUris.value + uri
        player?.addMediaItem(MediaItem.fromUri(uri))
    }

    fun playVideo(uri: Uri) {
        player?.apply {
            setMediaItem(
                videoItems.value.find { it.contentUri === uri }?.mediaItem ?: return,
            )
        }
    }

    fun initPlayer(context: Context) {
        if (_player == null) _player = VideoPlayerFactory.videoPlayer(context)
        player?.prepare()
        player?.playWhenReady = true
    }


    companion object {
        private const val VIDEO_URIS_KEY = "video_uris_key"
    }

}