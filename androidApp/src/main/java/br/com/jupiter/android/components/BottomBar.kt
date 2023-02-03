package br.com.jupiter.android.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BottomBar(title: String) {
  BottomAppBar(backgroundColor = Color(0xFF20B2AA)) {
    TextButton(onClick = { /*TODO*/ }) {
      Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White,  modifier = Modifier
        .padding())
    }
  }
}

@Preview
@Composable
fun BottomBarPreview() {
  BottomBar("Entrar")
}
