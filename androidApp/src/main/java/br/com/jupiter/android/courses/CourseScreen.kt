package br.com.jupiter.android.courses

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.CardCourseGroup
import br.com.jupiter.android.components.TopBarPerfil
import br.com.jupiter.android.components.TopBarPerfilOnly
import br.com.jupiter.model.Categorias

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen(onCategoryDetail: (String) -> Unit, navHostController: NavHostController?) {
    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBarPerfilOnly(title = "JUPITER") },
            containerColor = Color.Black,
        ) {

            LazyColumn(modifier = Modifier.padding(it)) {

                val categorias: Array<Categorias> = Categorias.values()

                for (categoria in categorias) {

                    item {
                        Row(
                            modifier = Modifier
                                .padding(20.dp),//Espaço entre as bordas do Texto
                            verticalAlignment = Alignment.CenterVertically //alinhados na vertical
                        ) {
                            Text(
                                text = categoria.name,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
                            IconButton(onClick = { onCategoryDetail.invoke(categoria.name) }) {
                                Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
                            }
                        }
                    }

                    item {
                        CardCourseGroup(categoria.name, navHostController = navHostController, onCard = {})
                    }

                }
            }
        }
    }
}


@Preview
@Composable
fun CourseScreenPreview() {
    CourseScreen(onCategoryDetail = {}, navHostController = null)
}
