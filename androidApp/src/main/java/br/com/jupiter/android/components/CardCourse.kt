package br.com.jupiter.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.R
import br.com.jupiter.android.courses.CourseViewModel
import br.com.jupiter.android.nav.Route
import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Curso
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@Composable
fun CardCourse(
    curso: Curso,
    onCardNavigation: (Long) -> Unit,
    navHostController: NavHostController?
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          .background(Color.White)
          .height(116.dp)
          .padding(horizontal = 32.dp)
          .clickable {}
    ) {
      Card() {
        TextButton(onClick = {
          //onCardNavigation.invoke(curso.id)

          navHostController?.navigate("${Route.CONTENT}/${curso.id}")
        }) {
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column(
              horizontalAlignment = Alignment.CenterHorizontally,
            ) {
              Image(
                painter = painterResource(id = R.drawable.porqueinho),
                contentDescription = "Dinheiro",
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(60.dp)
              )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(
              curso!!.titulo,
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold,
              color = Color.Black,
              textAlign = TextAlign.Center
            )
          }
        }
      }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CardCourseGroup(
    cursos: List<Curso>,
    categoria: String, onCard: (String) -> Unit,
    navHostController: NavHostController?
) {

    val cursosFiltrados: List<Curso> = cursos.filter { it.curso.toString() == categoria }

    HorizontalPager(
        count = cursosFiltrados.size,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = Modifier
          .height(125.dp)
          .clickable {

          }
    ) { page ->
        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
        Card(
            contentColor = Color.White,
            modifier = Modifier
              .fillMaxWidth()
              .graphicsLayer {
                lerp(
                  start = 0.90f,
                  stop = 1f,
                  fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also {
                  scaleY = it
                  scaleX = it
                }

              }
        ) {
            CardCourse(
                curso = cursosFiltrados[page],
                navHostController = navHostController,
                onCardNavigation = {})
        }
    }
}


@Preview
@Composable
fun CardCoursePreview() {
    CardCourse(Mock.curso1, {}, navHostController = null)
}

@Preview
@Composable
fun CardCourseGroupPreview() {
    CardCourseGroup(
        cursos = Mock.listaDeCursos,
        categoria = Categorias.FINANCAS.name,
        navHostController = null,
        onCard = {})
}

