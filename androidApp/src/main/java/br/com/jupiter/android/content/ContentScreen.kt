package br.com.jupiter.android.content

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.Route
import br.com.jupiter.android.components.CardCourse
import br.com.jupiter.android.components.ContentItem
import br.com.jupiter.android.components.TopBarPerfil
import br.com.jupiter.model.Conteudo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(function: () -> Unit) {
    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBarPerfil(title = "JUPITER") },
            containerColor = Color(0xFF20B2AA),
        ) {
            LazyColumn(modifier = Modifier.padding(it)) {
                val curso = Mock.curso1
                val listaDeConteudo: List<Conteudo>? = curso.conteudo

                item {
                    Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)) {
                        Card() {
                            CardCourse(curso = curso.titulo) {}
                        }
                    }
                }

                if (listaDeConteudo != null) {
                    items(listaDeConteudo.size) {
                        ContentItem(conteudo = listaDeConteudo[it])
                    }
                }

            }

        }
    }
}

@Preview
@Composable
fun ContentScreenPreview() {
    ContentScreen() {}
}




