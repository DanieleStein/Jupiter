package br.com.jupiter.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import br.com.jupiter.android.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@Composable
fun CardCourse(curso: String) {
  Column(
    modifier = Modifier
      .background(Color(0xFF0051EF))
      .height(116.dp)
      .padding(horizontal = 23.dp, vertical = 23.dp)
      .fillMaxWidth()
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Column() {
        Image(
          painter = painterResource(id = R.drawable.porqueinho),
          contentDescription = "Dinheiro")
      }
      Spacer(modifier = Modifier.weight(1f))
      Text(curso, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
  }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CardCourseGroup() {
  HorizontalPager(
    count = 4,
    contentPadding = PaddingValues(horizontal = 32.dp),
    modifier = Modifier.height(125.dp)) {
      page ->
    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
    Card(
      contentColor = Color.White,
      modifier = Modifier.graphicsLayer {
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
      CardCourse(curso = "CURSO DE FUNDOS DE INVESTIMENTO")

    }
  }
}

@Preview
@Composable
fun CardCoursePreview() {
  CardCourse("CURSO DE FUNDOS DE INVESTIMENTO")
}

@Preview
@Composable
fun CardCourseGroupPreview() {
  CardCourseGroup()
}
