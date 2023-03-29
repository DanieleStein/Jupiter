package br.com.jupiter.android.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.*
import br.com.jupiter.model.Conteudo
import br.com.jupiter.util.DataResult


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(navHostController: NavHostController?, id: Long?) {

    val contentViewModel = viewModel<ContentViewModel>()
    contentViewModel.getContent(id!!)
    val contents by contentViewModel.contents.collectAsState()

    MyApplicationTheme {
        Scaffold(
            topBar = { TopBarPerfil(title = "JUPITER", navHostController = navHostController) },
            containerColor = Color(0x7D0051EF),
        ) {

            when (contents) {
                is DataResult.Loading -> LoadingIndicator() //println("(CONTENT SCREEN) CARREGANDO")//
                is DataResult.Error -> ErrorMessage((contents as DataResult.Error).error)
                is DataResult.Success -> {

                    val listaDeConteudo = remember { mutableStateOf(emptyList<Conteudo>()) }
                    listaDeConteudo.value = (contents as DataResult.Success<List<Conteudo>>).data

                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                            .padding(horizontal = 23.dp, vertical = 23.dp)
                    ) {

                        items(listaDeConteudo.value.size) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Card {
                                ContentItem(
                                    conteudo = listaDeConteudo.value[it],
                                    navHostController = navHostController
                                )
                            }
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}

@Preview
@Composable
fun ContentScreenPreview() {
    ContentScreen(id = 1, navHostController = null)
}




