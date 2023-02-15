package br.com.jupiter.android.recoverPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.navigation.NavHostController
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecoverPasswordScreen(navHostController: NavHostController?) {
  MyApplicationTheme() {
    Scaffold(
      topBar = { TopBar(title = "JUPITER", navHostController = navHostController)},
      bottomBar = { BottomBar(title = "CONFIRMAR") {
      }}
    ) {

      val email = remember { mutableStateOf(TextFieldValue()) }
      val senha = remember { mutableStateOf(TextFieldValue()) }
      val confirmarSenha = remember { mutableStateOf(TextFieldValue()) }

      Column(
        modifier = Modifier
          .padding(it)
          .padding(horizontal = 16.dp, vertical = 16.dp)
      ) {

        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Passo 1 de 1", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "RECUPERAR SENHA", fontWeight = FontWeight.Bold, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9)),
          label = { Text(text = "Email") },
          value = email.value,
          onValueChange = { email.value = it },
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9)),
          label = { Text(text = "Senha") },
          value = senha.value,
          onValueChange = { senha.value = it },
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9)),
          label = { Text(text = "Confirmar Senha") },
          value = confirmarSenha.value,
          onValueChange = { confirmarSenha.value = it },
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

      }
    }
  }
}

@Preview
@Composable
fun RecoverPasswordScreenPreview() {
  RecoverPasswordScreen(null)
}
