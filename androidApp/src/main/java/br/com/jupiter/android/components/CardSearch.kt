package br.com.jupiter.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.jupiter.android.nav.Route
import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Curso


@Composable
fun CardSearch(curso: Curso, navHostController: NavHostController?) {

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .heightIn(200.dp)
            .fillMaxWidth()
            .clickable { navHostController?.navigate("${Route.CONTENT}/${curso.id}") }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 16.dp)

            ) {
                Text(
                    text = curso.titulo,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0051EF),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 30.dp)

            ) {
                Text(
                    text = curso.descricao,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}


@Preview
@Composable
fun CardSearchPreview() {
    CardSearch(
        Curso(
            id = 1,
            curso = Categorias.FINANCAS,
            titulo = LoremIpsum(40).values.first(),
            descricao = LoremIpsum(40).values.first(),
            conteudo = null,
            criador = null
            ),
        navHostController = null
    )
}
