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
import br.com.jupiter.model.Curso

@Composable
fun ContentItem(
    conteudo: Conteudo,
    navHostController: NavHostController?
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color(0xFF5091F2))
            .height(210.dp)
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Row() {
            Text(
                text = "${conteudo.ordemConteudo} - ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = conteudo.titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = conteudo.descricao,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.padding(10.dp))
        TextButton(onClick = {
            val rota = "${Route.VIDEO}/${conteudo.ordemConteudo}"
            println("CONTENTITEM: $rota")
            navHostController?.navigate(rota)
        }) {
            Text(
                text = "Clique Aqui!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        val checkedState = remember { mutableStateOf(false) }
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
        )
    }
}


@Preview
@Composable
fun ContentItemPreview() {

    val content = Mock.conteudo1
    ContentItem(conteudo = content, navHostController = null)
}
