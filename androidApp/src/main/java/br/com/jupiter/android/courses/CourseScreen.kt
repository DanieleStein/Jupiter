package br.com.jupiter.android.courses

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.TopBar
import br.com.jupiter.android.components.TopBarPerfil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen() {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBarPerfil(title = "JUPITER") },
    ) {
     LazyColumn(modifier = Modifier.padding(it)) {
       

     }
    }
  }

}

@Preview
@Composable
fun CourseScreenPreview() {
  CourseScreen()
}
