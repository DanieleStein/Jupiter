package br.com.jupiter.android.courses

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.CardCourseGroup
import br.com.jupiter.android.components.TopBarPerfil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen() {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBarPerfil(title = "JUPITER") },
      containerColor = Color(0xFF20B2AA),
    ) {

      Spacer(modifier = Modifier.height(50.dp))
     LazyColumn(modifier = Modifier.padding(it)) {

       item {
         Row(
           modifier = Modifier
             .padding(20.dp),//Espaço entre as bordas do Texto
           verticalAlignment = Alignment.CenterVertically //alinhados na vertical
         ) {
           Text(text = "FINANÇAS", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
           Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
           IconButton(onClick = { /*TODO*/ }) {
             Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
           }
         }
       }

       item {
         CardCourseGroup()
       }

       item {
         Row(
           modifier = Modifier
             .padding(20.dp),//Espaço entre as bordas do Texto
           verticalAlignment = Alignment.CenterVertically //alinhados na vertical
         ) {
           Text(text = "FINANÇAS", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
           Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
           IconButton(onClick = { /*TODO*/ }) {
             Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
           }
         }
       }

       item {
         CardCourseGroup()
       }

       item {
         Row(
           modifier = Modifier
             .padding(20.dp),//Espaço entre as bordas do Texto
           verticalAlignment = Alignment.CenterVertically //alinhados na vertical
         ) {
           Text(text = "FINANÇAS", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
           Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
           IconButton(onClick = { /*TODO*/ }) {
             Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
           }
         }
       }

       item {
         CardCourseGroup()
       }

       item {
         Row(
           modifier = Modifier
             .padding(20.dp),//Espaço entre as bordas do Texto
           verticalAlignment = Alignment.CenterVertically //alinhados na vertical
         ) {
           Text(text = "FINANÇAS", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
           Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
           IconButton(onClick = { /*TODO*/ }) {
             Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
           }
         }
       }

       item {
         CardCourseGroup()
       }

       item {
         Row(
           modifier = Modifier
             .padding(20.dp),//Espaço entre as bordas do Texto
           verticalAlignment = Alignment.CenterVertically //alinhados na vertical
         ) {
           Text(text = "MAIS CURSOS", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
           Spacer(modifier = Modifier.weight(1f)) //espaço entre a escrita e a seta
           IconButton(onClick = { /*TODO*/ }) {
             Icon(Icons.Filled.ArrowForward, "backIcon", tint = Color.White)
           }
         }
       }
     }
    }
  }

}

@Preview
@Composable
fun CourseScreenPreview() {
  CourseScreen()
}
