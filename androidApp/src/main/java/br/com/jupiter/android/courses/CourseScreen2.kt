package br.com.jupiter.android.courses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.CardCourse
import br.com.jupiter.android.components.TopBarCourse
import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Curso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen2(categoria: String, cursos: List<Curso> ,navHostController: NavHostController?) {

/*  val viewModel = viewModel<CourseViewModel>()
  val cursos by viewModel.cursos.collectAsState()*/

  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBarCourse(titulo = "JUPITER", navHostController = navHostController) },
      containerColor = Color.Black
    ) { curso ->

      LazyColumn(modifier = Modifier
        .padding(curso)
        .padding(horizontal = 23.dp, vertical = 23.dp)
      ) {


        val cursosFiltrados: List<Curso> =
          cursos.filter { it.curso.toString() == categoria }

        item {
          Row(
            modifier = Modifier.padding(20.dp),//Espaço entre as bordas do Texto
            verticalAlignment = Alignment.CenterVertically //alinhados na vertical
          ) {
            Text(text = cursosFiltrados[0].curso.nome, fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
          }

        }

        items(cursosFiltrados.size) { page ->
          Spacer(modifier = Modifier.height(20.dp))
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
            Card() {
              CardCourse(curso = cursosFiltrados[page], onCardNavigation = {}, navHostController = navHostController)
            }
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun CourseScreen2Preview() {
  CourseScreen2(Categorias.FINANCAS.name, navHostController = null, cursos = Mock.listaDeCursos)
}

