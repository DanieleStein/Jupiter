package br.com.jupiter.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jupiter.Objects.Mock
import br.com.jupiter.model.Conteudo

@Composable
fun ContentItem(conteudo: Conteudo) {
    Column(
      verticalArrangement = Arrangement.Center,
      modifier = Modifier
        .background(Color.White)
        .height(250.dp)
        .fillMaxWidth()
        .padding()
    ) {
        Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)) {
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
        Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp)) {
            Text(
                text = conteudo.descricao,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Row(modifier = Modifier.padding(horizontal = 50.dp)) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = conteudo.url,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun ContentItemPreview() {

    val content = Mock.conteudo1
    ContentItem(conteudo = content)


}
