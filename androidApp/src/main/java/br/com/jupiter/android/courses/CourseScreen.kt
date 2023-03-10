package br.com.jupiter.android.courses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
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
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.CardCourseGroup
import br.com.jupiter.android.components.ErrorMessage
import br.com.jupiter.android.components.LoadingIndicator
import br.com.jupiter.android.components.TopBarPerfilOnly
import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Curso
import br.com.jupiter.util.DataResult


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen(
    onCursos: (DataResult<List<Curso>>) -> Unit,
    onCategoryDetail: (String) -> Unit, navHostController: NavHostController?
) {
    val courseViewModel = viewModel<CourseViewModel>()
    val cursos by courseViewModel.cursos.collectAsState()

    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBarPerfilOnly(title = "JUPITER") },
            containerColor = Color.Black,
        ) {

            when (cursos) {
                is DataResult.Loading -> LoadingIndicator() // println("(COURSE SCREEN) CARREGANDO")
                is DataResult.Error -> ErrorMessage((cursos as DataResult.Error).error)
                is DataResult.Success -> {
                    LazyColumn(modifier = Modifier.padding(it)) {

                        val categorias: Array<Categorias> = Categorias.values()
                        for (categoria in categorias) {

                            item {
                                Row(
                                    modifier = Modifier.padding(20.dp),//Espa??o entre as bordas do Texto
                                    verticalAlignment = Alignment.CenterVertically //alinhados na vertical
                                ) {
                                    Text(
                                        text = categoria.nome,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.weight(1f)) //espa??o entre a escrita e a seta
                                    IconButton(onClick = {
                                        onCategoryDetail.invoke(categoria.name)
                                    }) {
                                        Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
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
                    }
                    onCursos.invoke(cursos)
                }
                else -> Unit
            }
        }
    }
}





/*@Preview
@Composable
fun CourseScreenPreview() {
    CourseScreen(onCategoryDetail = {}, navHostController = null, onCursos = )
}*/
