package br.com.jupiter.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.nav.Route
import br.com.jupiter.model.Conteudo

@Composable
fun ContentItem(conteudo: Conteudo, navHostController: NavHostController?) {
  Column(
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .background(Color.White)
      .height(250.dp)
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 20.dp)
  ) {
    Row() {
      Text(
        text = "${conteudo.ordemConteudo} - ",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0051EF)
      )
      Text(
        text = conteudo.titulo,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0051EF)
      )
    }

    Spacer(modifier = Modifier.padding(10.dp))
    Text(
      text = conteudo.descricao,
      fontSize = 16.sp,
      fontWeight = FontWeight.Bold,
      color = Color.Black
    )

    Spacer(modifier = Modifier.padding(10.dp))
    TextButton(onClick = { navHostController?.navigate(Route.VIDEO.name) }) {
      Text(
        text = conteudo.url,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
      )
    }

    Row(
      modifier = Modifier.padding(horizontal = 330.dp)
    ) {
      SwitchDemo()
    }

  }
}

@Composable
fun SwitchDemo() {
  val checkedState = remember { mutableStateOf(false) }
  Switch(
    checked = checkedState.value,
    onCheckedChange = { checkedState.value = it },
  )
}


@Preview
@Composable
fun ContentItemPreview() {

    val content = Mock.conteudo1
    ContentItem(conteudo = content, navHostController = null)
}
