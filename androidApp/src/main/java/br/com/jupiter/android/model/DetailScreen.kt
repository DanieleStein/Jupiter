package br.com.jupiter.android.model

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen() {

    val viewModel = viewModel<VideoViewModel>()
    var lifecycle by remember { mutableStateOf(Lifecycle.Event.ON_CREATE) }
    val currentView = LocalView.current
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner) {
        viewModel.initPlayer(currentView.context)
        currentView.keepScreenOn = true
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            currentView.keepScreenOn = false
        }

    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Games") })
        },
        content = { DetailContent(viewModel, lifecycle) }


    )

}

@Composable
fun DetailContent(viewModel: VideoViewModel, lifecycle: Lifecycle.Event) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        viewModel.player?.let { CustomPlayer(player = it, lifecycle = lifecycle) }

        val uri =
            Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        viewModel.addVideoUri(uri)
        viewModel.playVideo(uri)


        /*Button(onClick = {
            val uri =
                Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            viewModel.addVideoUri(uri)
            viewModel.playVideo(uri)
        }) {
            Text(text = "Carrega!")
        }*/
    }
}