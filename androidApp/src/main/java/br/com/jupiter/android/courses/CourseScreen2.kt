package br.com.jupiter.android.courses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.CardCourse
import br.com.jupiter.android.components.CardCourse2
import br.com.jupiter.android.components.TopBarPerfil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen2() {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBarPerfil(title = "JUPITER") },
      containerColor = Color(0xFF20B2AA)
    ) {

      LazyColumn(modifier = Modifier.padding(it).padding(horizontal = 23.dp, vertical = 23.dp)
      ) {

        item {
          Row(
            modifier = Modifier.padding(20.dp),//Espaço entre as bordas do Texto
            verticalAlignment = Alignment.CenterVertically //alinhados na vertical
          ) {
            Text(text = "FINANÇAS", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }
        }

        items(7) {
          Spacer(modifier = Modifier.height(20.dp))
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
                CardCourse(curso = "Curso de finança básico") {}
          }
        }

      }
    }
  }
}

@Preview
@Composable
fun CourseScreen2Preview() {
  CourseScreen2()
}

