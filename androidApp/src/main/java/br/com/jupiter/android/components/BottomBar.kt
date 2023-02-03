package br.com.jupiter.android.components

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun BottomBar(title: String) {
  BottomAppBar(backgroundColor = Color(0xFF20B2AA)) {
      Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
  }
}

@Preview
@Composable
fun BottomBarPreview() {
  BottomBar("Entrar")
}
