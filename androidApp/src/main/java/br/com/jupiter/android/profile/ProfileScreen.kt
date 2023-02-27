package br.com.jupiter.android.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.TopBarProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBarProfile(title = "JUPITER", navHostController = null) },
      bottomBar = { BottomBar(title = "CONFIRMAR", onClick = {} )}
    ) {
      LazyColumn(
        modifier = Modifier
          .padding(it)
          .padding(horizontal = 16.dp, vertical = 16.dp)
      ) {

        var nome = "Daniele Stein"
        var email = "danieleastein@gmail.com"
        var dataNascimento = "08-11-1991"
        var cpf = "12345678910"

        item {
          Spacer(modifier = Modifier.height(40.dp))
          Text(text = "DADOS PESSOAIS", fontWeight = FontWeight.Bold, fontSize = 22.sp)

          Spacer(modifier = Modifier.height(30.dp))
          Text(text = "NOME COMPLETO", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = nome,
            onValueChange = { nome = it }
          )

          Spacer(modifier = Modifier.height(15.dp))
          Text(text = "EMAIl", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = email,
            onValueChange = { email = it }
          )

          Spacer(modifier = Modifier.height(15.dp))
          Text(text = "DATA DE NASCIMENTO", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = dataNascimento,
            onValueChange = { dataNascimento = it }
          )

          Spacer(modifier = Modifier.height(15.dp))
          Text(text = "CPF", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = cpf,
            onValueChange = { cpf }
          )
        }

        var nomeCartao = "Daniele Aline Stein"
        var numeroCartao = "1234 2345 1234 5678"
        var dataValidade = "24-09-2030"

        item {
          Spacer(modifier = Modifier.height(40.dp))
          Text(text = "DADOS DO CARTÃO", fontWeight = FontWeight.Bold, fontSize = 22.sp)

          Spacer(modifier = Modifier.height(30.dp))
          Text(text = "NOME NO CARTÃO", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = nomeCartao,
            onValueChange = { nomeCartao = it },
          )

          Spacer(modifier = Modifier.height(15.dp))
          Text(text = "CPF", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = numeroCartao,
            onValueChange = { numeroCartao = it },
          )

          Spacer(modifier = Modifier.height(15.dp))
          Text(text = "CPF", fontWeight = FontWeight.Bold, fontSize = 15.sp)
          OutlinedTextField(
            modifier = Modifier
              .fillMaxWidth()
              .background(Color(0xFFD9D9D9)),
            value = dataValidade,
            onValueChange = { dataValidade = it },
          )
        }

      }
    }
  }
}

@Composable
@Preview
fun ProfileScreenPreview() {
  ProfileScreen()
}
