package br.com.jupiter.android.registerUser1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import br.com.jupiter.android.components.TopBarCourse
import br.com.jupiter.android.components.TopBarPerfil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterUserScreen(
    onNextButtonClicked: () -> Unit,
    navHostController: NavHostController?,
) {

    val nome = remember { mutableStateOf(TextFieldValue()) }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val senha = remember { mutableStateOf(TextFieldValue()) }
    val dataNascimento = remember { mutableStateOf(TextFieldValue()) }
    val cpf = remember { mutableStateOf(TextFieldValue()) }

    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBar(title = "JUPITER", navHostController = navHostController) },
            bottomBar = { BottomBar(title = "CONTINUAR", onClick = {
                    /*val usuario: Usuario = Usuario(
                        id = 0,
                        nome = nome.value.text,
                        email = email.value.text,
                        senha = senha.value.text,
                        dataNascimento = dataNascimento.value.text,
                        cpf = cpf.value.text,
                        cartao = listOf(),
                        pedido = listOf()
                    )*/
                    //onNextButtonClicked(usuario)
                    onNextButtonClicked.invoke()
            })
            }
        ) {

            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {


                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Passo 1 de 3", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "DADOS PESSOAIS", fontWeight = FontWeight.Bold, fontSize = 22.sp)

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9)),
                    label = { Text(text = "Nome Completo") },
                    value = nome.value,
                    onValueChange = { nome.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(15.dp))
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
                    label = { Text(text = "Data de Nascimento") },
                    value = dataNascimento.value,
                    onValueChange = { dataNascimento.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9)),
                    label = { Text(text = "CPF") },
                    value = cpf.value,
                    onValueChange = { cpf.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

            }
        }
    }
}

@Preview
@Composable
fun RegisterUserScreenPreview() {
    RegisterUserScreen(onNextButtonClicked = {}, navHostController = null)
}
