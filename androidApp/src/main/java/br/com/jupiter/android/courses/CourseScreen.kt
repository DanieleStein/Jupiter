package br.com.jupiter.android.courses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.*
import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Curso
import br.com.jupiter.util.DataResult


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen(
    onCursos: (DataResult<List<Curso>>) -> Unit,
    onCategoryDetail: (String) -> Unit,
    navHostController: NavHostController?
) {
    val courseViewModel = viewModel<CourseViewModel>()
    val cursos by courseViewModel.cursos.collectAsState()

    var texto by remember { mutableStateOf("") }
    val listaCursos = remember(texto) { mutableStateOf(emptyList<Curso>()) }


    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopBarPerfil(
                    title = "JUPITER",
                    navHostController = navHostController
                )
            },
            containerColor = Color.Black,
        ) {


            when (cursos) {
                is DataResult.Loading -> LoadingIndicator()
                is DataResult.Error -> ErrorMessage((cursos as DataResult.Error).error)
                is DataResult.Success -> {

                    LazyColumn(modifier = Modifier.padding(it)) {
                        item {
                            OutlinedTextField(
                                value = texto,
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color.White,
                                    unfocusedBorderColor = Color.White,
                                    focusedLabelColor = Color.White,
                                    textColor = Color.White,
                                    cursorColor = Color.White
                                ),
                                onValueChange = { text -> texto = text },
                                modifier = Modifier
                                    .padding(
                                        start = 16.dp,
                                        top = 16.dp,
                                        end = 16.dp
                                    )
                                    .background(Color.Black)
                                    .fillMaxWidth(),
                                label = {
                                    Text(text = "Curso", color = Color.White)
                                },
                                leadingIcon = {
                                    Icon(
                                        Icons.Default.Search,
                                        contentDescription = "Icone de Lupa",
                                        tint = Color.White
                                    )
                                },
                                placeholder = {
                                    Text(text = "Qual curso procura?", color = Color.White)
                                }
                            )
                        }
                        if (texto.isBlank()) {
                            val categorias: Array<Categorias> = Categorias.values()
                            for (categoria in categorias) {
                                item {
                                    Row(
                                        modifier = Modifier.padding(20.dp),//Espaço entre as bordas do Texto
                                        verticalAlignment = Alignment.CenterVertically //alinhados na vertical
                                    ) {
                                        Text(
                                            text = categoria.nome,
                                            fontSize = 22.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                        Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
                                        IconButton(onClick = {
                                            onCategoryDetail.invoke(categoria.name)
                                        }) {
                                            Icon(
                                                Icons.Filled.ArrowForward,
                                                "backIcon",
                                                tint = Color.White
                                            )
                                        }
                                    }

                                }
                                item {
                                    CardCourseGroup(
                                        listDataResult = cursos,
                                        categoria = categoria.name,
                                        navHostController = navHostController,
                                        onCard = {})
                                }
                            }

                        } else {

                            listaCursos.value =
                                (cursos as DataResult.Success<List<Curso>>).data.filter { curso ->
                                    curso.titulo.contains(texto, ignoreCase = true) ||
                                            curso.descricao.contains(texto, ignoreCase = true)
                                }

                            items(listaCursos.value.size) { p ->
                                CardSearch(
                                    listaCursos.value[p],
                                    navHostController = navHostController
                                )
                            }
                        }
                    }
                    onCursos.invoke(cursos)
                }
                else -> Unit
            }
        }
    }
}


@Preview
@Composable
fun CourseScreenPreview() {
    CourseScreen(onCategoryDetail = {}, navHostController = null, onCursos = {
        DataResult.Success(data = Mock.listaDeCursos)
    })
}
