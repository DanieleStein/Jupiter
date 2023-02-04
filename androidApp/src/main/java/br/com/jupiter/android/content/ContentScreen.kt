package br.com.jupiter.android.content

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.CardCourse
import br.com.jupiter.android.components.TopBarPerfil


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen() {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBarPerfil(title = "JUPITER") },
      containerColor = Color.Black,
    ) {

      val ordemConteudo = 1
      val titulo = " Onde guardar seu dinheiro?"
      val descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo!"
      val url = "CONFIRA A AULA AQUI!!"

      LazyColumn(modifier = Modifier.padding(it)) {
        item {
          Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)) {
            Card() {
              CardCourse(curso = "Curso de Fundos de Investimento")
            }
          }
        }

        item {
          Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)) {
            Text(text = "${ordemConteudo} - ", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
            Text(text = titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
          }
          Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp)) {
            Text(text = descricao, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }
          Row(modifier = Modifier.padding(horizontal = 50.dp)) {
            TextButton(onClick = { /*TODO*/ }) {
              Text(text = url, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }

        item {
          Row(modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)) {
            Text(text = "${ordemConteudo} - ", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
            Text(text = titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
          }
          Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp)) {
            Text(text = descricao, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }
          Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp)) {
            TextButton(onClick = { /*TODO*/ }) {
              Text(text = url, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }

        item {
          Row(modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)) {
            Text(text = "${ordemConteudo} - ", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
            Text(text = titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
          }
          Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp)) {
            Text(text = descricao, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }
          Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp)) {
            TextButton(onClick = { /*TODO*/ }) {
              Text(text = url, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }

        item {
          Row(modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)) {
            Text(text = "${ordemConteudo} - ", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
            Text(text = titulo, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0051EF))
          }
          Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 30.dp)) {
            Text(text = descricao, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }
          Row(modifier = Modifier.padding(vertical = 5.dp, horizontal = 50.dp)) {
            TextButton(onClick = { /*TODO*/ }) {
              Text(text = url, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
          }
        }

      }
    }
  }
}

@Preview
@Composable
fun ContentScreenPreview() {
  ContentScreen()
}
