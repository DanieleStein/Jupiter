package br.com.jupiter.android.content

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.ContentItem
import br.com.jupiter.android.components.TopBarPerfil
import br.com.jupiter.model.Conteudo
import br.com.jupiter.model.Curso


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(onBack: () -> Unit, id: Int) {
    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBarPerfil(title = "JUPITER") },
            containerColor = Color.Black,
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 23.dp, vertical = 23.dp)
            ) {

                val listaDeCurso: List<Curso> = Mock.listaDeCursos
                val curso: Curso = listaDeCurso[id]
                val listaDeConteudo: List<Conteudo>? = listaDeCurso[id].conteudo

                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp)) {
                        Text(
                            text = curso.titulo,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                if (listaDeConteudo != null) {
                    items(listaDeConteudo.size) {
                        Spacer(modifier = Modifier.height(20.dp))
                        Card() {
                            ContentItem(conteudo = listaDeConteudo[it])
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
    ContentScreen(id = 1, onBack = {  } )
}




