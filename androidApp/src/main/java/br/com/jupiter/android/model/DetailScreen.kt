package br.com.jupiter.android.model

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    navHostController: NavHostController?,
    ordemConteudo: Int
) {

    val viewModel = viewModel<VideoViewModel>()
    var lifecycle by remember { mutableStateOf(Lifecycle.Event.ON_CREATE) }
    val currentView = LocalView.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val listaURL = Mock.listaVideos


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
            topBar = { TopBar(title = "JUPITER", navHostController = navHostController) },
            content = {
                DetailContent(
                    viewModel = viewModel,
                    lifecycle = lifecycle,
                    url = listaURL[ordemConteudo]
                )
            },
            backgroundColor = Color.Black,
        )
    }
}

@Composable
fun DetailContent(viewModel: VideoViewModel, lifecycle: Lifecycle.Event, url: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        viewModel.player?.let { CustomPlayer(player = it, lifecycle = lifecycle) }

        val uri = Uri.parse(url)
        viewModel.addVideoUri(uri)
        viewModel.playVideo(uri)
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(navHostController = null, ordemConteudo = 1)
}
