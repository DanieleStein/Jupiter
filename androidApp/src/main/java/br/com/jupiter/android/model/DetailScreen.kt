package br.com.jupiter.android.model

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.TopBar
import br.com.jupiter.android.components.TopBar1Preview

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
    MyApplicationTheme() {
      Scaffold(
        topBar = { TopBar(title = "JUPITER", navHostController = null) },
        content = { DetailContent(viewModel, lifecycle) },
        backgroundColor = Color.Black,
      )
    }
}

@Composable
fun DetailContent(viewModel: VideoViewModel, lifecycle: Lifecycle.Event) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
    ) {
        viewModel.player?.let { CustomPlayer(player = it, lifecycle = lifecycle) }

        val uri =
            Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        viewModel.addVideoUri(uri)
        viewModel.playVideo(uri)
    }
}

@Preview
@Composable
fun DetailScreenPreiew() {
  DetailScreen()
}
