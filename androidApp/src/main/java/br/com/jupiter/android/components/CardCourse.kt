package br.com.jupiter.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.R
import br.com.jupiter.android.nav.Route
import br.com.jupiter.model.Curso
import br.com.jupiter.util.DataResult
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
  //val painter = rememberAsyncImagePainter(
   // model =
   // ImageRequest.Builder(LocalContext.current)
    //  .data("https://picsum.photos/200/300?random=2")
    //  .size(60)
    //  .build()
  //)

  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .background(Color(0xFF5091F2))
      .height(116.dp)
      .padding(horizontal = 32.dp)
      .clickable {}
  ) {
    Card() {
      TextButton(
        modifier = Modifier.background(Color(0xFF5091F2)),
        onClick = {
        //onCardNavigation.invoke(curso.id)

        navHostController?.navigate("${Route.CONTENT}/${curso.id}")
      }) {
        Row(
          modifier = Modifier
            .background(Color(0xFF5091F2)),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            Image(
              painter = painterResource(id = R.drawable.porquinho),
              //painter = painterResource(id = R.drawable.porqueinho),
              contentDescription = "Dinheiro",
              contentScale = ContentScale.Crop,
              modifier = Modifier
                .height(70.dp)
                .width(50.dp)
                .clip(CircleShape)
            )
          }
          Spacer(modifier = Modifier.width(20.dp))
          Text(
            curso!!.titulo,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
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
    listDataResult: DataResult<List<Curso>>,
    categoria: String, onCard: (String) -> Unit,
    navHostController: NavHostController?
) {

    val cursos = remember { mutableStateOf(emptyList<Curso>()) }
    cursos.value = (listDataResult as DataResult.Success<List<Curso>>).data

    val cursosFiltrados: List<Curso> = cursos.value.filter { it.curso.toString() == categoria }

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

/*@Preview
@Composable
fun CardCourseGroupPreview() {
    CardCourseGroup(
        listDataResult = Mock.listaDeCursos,
        categoria = Categorias.FINANCAS.name,
        navHostController = null,
        onCard = {})
}*/

