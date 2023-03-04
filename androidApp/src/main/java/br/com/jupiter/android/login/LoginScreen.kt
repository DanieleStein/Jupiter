package br.com.jupiter.android.login

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.UnfocusedBorderThickness
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.R
import br.com.jupiter.android.components.AlertDialogComponent
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.LoadingIndicator
import br.com.jupiter.model.Login
import br.com.jupiter.util.DataResult
import java.util.regex.Pattern



@Composable
fun LoginScreen(
    onHomeNavigate: () -> Unit,
    onCreateNavigate: () -> Unit,
    onRecoveryNavigate: () -> Unit
) {
    val email = remember { mutableStateOf(TextFieldValue()) }
    val senha = remember { mutableStateOf(TextFieldValue()) }
    val erroEmail = remember { mutableStateOf(false) }
    val erroSenha= remember { mutableStateOf(false) }
    val senhavisivel = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }
    val showLoading = remember { mutableStateOf(false) }
    val modelLogin = viewModel<LoginViewModel>()
    val loginState by modelLogin.loginState.collectAsState()

    when (loginState) {
        is DataResult.Loading -> {
            Toast.makeText(LocalContext.current, "AGUARDE INVESTIDOR", Toast.LENGTH_SHORT).show()
            showLoading.value = true
            modelLogin.defaultState()
        }
        is DataResult.Error -> {
            Toast.makeText(LocalContext.current, "ERRO", Toast.LENGTH_SHORT).show()
            showDialog.value = true
            showLoading.value = false
            modelLogin.defaultState()
        }
        is DataResult.Success -> {
            onHomeNavigate.invoke()
            modelLogin.defaultState()
        }
        else -> Unit
    }



    MyApplicationTheme() {
        Scaffold(bottomBar = {
            BottomBar(title = "ENTRAR") {

                if (email.value.text.isBlank() || isEmailValido(email.value.text) ) {

                    erroEmail.value = true
                }
                else if (senha.value.text.isBlank()) {
                    erroSenha.value = true
                }
                else {
                    modelLogin.getLoginState(
                        Login(email = email.value.text, senha = senha.value.text)
                    )
                }

            }
        }, backgroundColor = Color(0xFF0051EF)) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(80.dp))
                Image(
                    painter = painterResource(R.drawable.jupiteragora),
                    contentDescription = "Jupiter",
                    modifier = Modifier.size(250.dp)
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = email.value,
                    singleLine = true,
                    isError = erroEmail.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedLabelColor = Color.White,
                        textColor = Color.White,
                        cursorColor = Color.White
                    ),
                    label = { Text(text = "Email") },
                    onValueChange = {
                        erroEmail.value = false
                        email.value = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                if (erroEmail.value) {
                    Text(
                        text = "Email inválido ou vazio",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth(),
                    value = senha.value,
                    singleLine = true,
                    isError = erroSenha.value,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedLabelColor = Color.White,
                        textColor = Color.White,
                        cursorColor = Color.White
                    ),
                    label = { Text(text = "Senha") },
                    onValueChange = {
                        erroSenha.value = false
                        senha.value = it },
                    visualTransformation = if (senhavisivel.value.not()) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val description = if (senhavisivel.value.not()) "Visivel" else "Invisivel"
                        val icone =
                            if (senhavisivel.value.not()) Icons.Filled.Visibility  else Icons.Filled.VisibilityOff
                        IconButton(onClick = { senhavisivel.value = senhavisivel.value.not() }) {
                            Icon(imageVector = icone, contentDescription = description, tint = Color.White)
                        }
                    })
                if (erroSenha.value) {
                    Text(
                        text = "A senha não pode estar vazia",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = { onCreateNavigate.invoke() }) {
                        Text(
                            text = "CADASTRAR CONTA",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = {
                        onRecoveryNavigate.invoke()
                    }) {
                        Text(
                            text = "ESQUECI SENHA",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))

                Row() {
                    if (showLoading.value) {
                        LoadingIndicator()
                    }
                }

                AlertDialogComponent(openDialog = showDialog.value,
                    title = "Erro",
                    message = "Login e/ou senha errada!",
                    onDismissRequest = { showDialog.value = false })

            }
        }
    }
}


fun isEmailValido(email: String) : Boolean {
    val REGEX = "^(.+)@(.+)\$"
    val resultado:Boolean = Pattern.matches(REGEX, email)
    println("IsEmailValido: $resultado")
    return !resultado
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onHomeNavigate = {}, onCreateNavigate = {}, onRecoveryNavigate = {})
}
