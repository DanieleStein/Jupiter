package br.com.jupiter.android.orders

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen() {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBar(title = "JUPITER") },
      bottomBar = { BottomBar(title = "CONFIRMAR") }
    ) {
      Column(
        modifier = Modifier
          .padding(it)
          .padding(horizontal = 16.dp, vertical = 16.dp)
      ) {

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Passo 3 de 3", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "DADOS DO PEDIDO", fontWeight = FontWeight.Bold, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Nome: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Email: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Data de Nascimento: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "CPF: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Número do Cartão: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Data de Validade: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(20.dp))
        Row(
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(text = "Valor: ", fontWeight = FontWeight.Bold, fontSize = 18.sp)
          Text(text = " R$ 25.90 ", fontWeight = FontWeight.Bold, color = Color.Green, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Válidade acesso a plataforma: 12 meses", fontWeight = FontWeight.Bold, fontSize = 18.sp)


      }
    }
  }
}

@Preview
@Composable
fun OrderScreenPreview() {
  OrderScreen()
}
