package br.com.jupiter.android.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.R
import br.com.jupiter.android.components.AlertDialogComponent
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.model.Login


@Composable
fun LoginScreen(
  onHomeNavigate: () -> Unit, onCreateNavigate: () -> Unit) {
  val email = remember { mutableStateOf(TextFieldValue()) } //Lembrar valor informado na ultima vez
  val senha = remember { mutableStateOf(TextFieldValue()) }
  val senhavisivel = remember { mutableStateOf(false) }
  val showDialog = remember { mutableStateOf(false) }

  MyApplicationTheme() {
    Scaffold(bottomBar = { BottomBar(title = "ENTRAR", onClick = {
      val login = Login(email = email.value.text, senha = senha.value.text)
      if (login.validacao()){
        onHomeNavigate.invoke()
      } else {
        showDialog.value = true
      }
    })  }, backgroundColor = Color(0xFF0051EF)) {
      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          .padding(it)
          .padding(horizontal = 30.dp, vertical = 30.dp)
          .verticalScroll(rememberScrollState())
      ) {

        Spacer(modifier = Modifier.height(100.dp))
        Image(
          painter = painterResource(R.drawable.jupiterlogin3),
          contentDescription = "Profile",
          modifier = Modifier)

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "EMAIL", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White, modifier = Modifier
          .padding()
          .fillMaxWidth())

        Spacer(modifier = Modifier.height(5.dp))
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

        Spacer(modifier = Modifier.height(5.dp))
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
          TextButton(onClick = { onCreateNavigate.invoke() }) {
            Text(text = "CADASTRAR CONTA", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
          }
          Spacer(modifier = Modifier.weight(1f))
          TextButton(onClick = {

          }) {
            Text(text = "ESQUECI SENHA", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
          }
        }

        AlertDialogComponent(
          openDialog = showDialog.value,
          title = "Erro",
          message = "Login e/ou senha errada!",
          onDismissRequest = { showDialog.value = false }
        )

      }
    }
  }
}

@Preview
@Composable
fun LoginScreenPreview() {
  LoginScreen({ },{ })
}
