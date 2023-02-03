package br.com.jupiter.android.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.BottomBar


@Composable
fun LoginScreen() {
  MyApplicationTheme() {
    Scaffold(bottomBar = { BottomBar(title = "ENTRAR")}, backgroundColor = Color(0xFF0051EF)) {
      Column(//Tudo da coluna vai ficar alinhado na vertical da tela e na horizontal
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          .padding(it)
          .padding(horizontal = 30.dp, vertical = 30.dp)
      ) {
        val email = remember { mutableStateOf(TextFieldValue()) } //Lembrar valor informado na ultima vez
        val senha = remember { mutableStateOf(TextFieldValue()) }
        val senhavisivel = remember { mutableStateOf(false) }

        //Image( //Vai ser uma imagem
          //painter = painterResource(R.drawable.jupiter),
          //contentDescription = "Profile",
          //modifier = Modifier
        //)
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "JUPITER", fontWeight = FontWeight.Bold, fontSize = 32.sp, color = Color.White)
        Text(text = "A PLATAFORMA DAS PLATAFORMAS", fontSize =16.sp, color = Color.White)

        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "EMAIL", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White, modifier = Modifier
          .padding()
          .fillMaxWidth())

        OutlinedTextField(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9)),
          value = email.value,
          onValueChange = {email.value = it},
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "SENHA", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White, modifier = Modifier
          .padding()
          .fillMaxWidth())

        OutlinedTextField(
          modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9)),
          value = senha.value,
          onValueChange = {senha.value = it},
          visualTransformation = if(senhavisivel.value.not()) {
            VisualTransformation.None
          } else {
            PasswordVisualTransformation()
          },
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
          trailingIcon = {
            val description = if(senhavisivel.value.not()) "Visivel" else "Invisivel"
            val icone = if(senhavisivel.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = { senhavisivel.value = senhavisivel.value.not() }) {
              Icon(imageVector = icone, contentDescription = description)
            }
          }
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
          verticalAlignment = Alignment.CenterVertically
        ) {
          TextButton(onClick = { /*TODO*/ }) {
            Text(text = "CADASTRAR CONTA", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
          }
          Spacer(modifier = Modifier.weight(1f))
          TextButton(onClick = { /*TODO*/ }) {
            Text(text = "ESQUECI SENHA", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun LoginScreenPreview() {
  LoginScreen()
}
