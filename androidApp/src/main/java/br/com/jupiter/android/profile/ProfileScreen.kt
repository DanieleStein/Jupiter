package br.com.jupiter.android.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.LoadingIndicator
import br.com.jupiter.android.components.TopBarProfile
import br.com.jupiter.android.login.LoginViewModel
import br.com.jupiter.android.nav.Route
import br.com.jupiter.model.Usuario
import br.com.jupiter.util.DataResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navHostController: NavHostController?) {

    val viewModel = viewModel<ProfileViewModel>()
    val profileState by viewModel.content.collectAsState()

    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBarProfile(title = "JUPITER", navHostController = navHostController) },
            bottomBar = {
                BottomBar(
                    title = "CONFIRMAR",
                    onClick = { navHostController?.navigate(Route.COURSES.name) })
            }
        ) {

            when (profileState) {
                is DataResult.Empty -> LoadingIndicator()
                is DataResult.Success -> {

                    val usuario: Usuario = (profileState as DataResult.Success<Usuario>).data
                    var nome = usuario.nome
                    var email = usuario.email
                    var dataNascimento = usuario.dataNascimento
                    var cpf = usuario.cpf

                    var nomeCartao: String? = ""
                    var numeroCartao: String? = ""
                    var dataValidade: String? = ""

                    if (usuario.cartao!!.isNotEmpty()){
                        nomeCartao = usuario.cartao!!.first().nomeCartao
                        numeroCartao = usuario.cartao!!.first().numeroCartao
                        dataValidade = usuario.cartao!!.first().dataValidade

                    }


                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                            .padding(horizontal = 16.dp, vertical = 16.dp)
                    ) {

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
                            Text(text = "EMAIL", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFD9D9D9)),
                                value = email,
                                onValueChange = { email = it }
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "DATA DE NASCIMENTO",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
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


                        item {
                            Spacer(modifier = Modifier.height(40.dp))
                            Text(text = "DADOS DO CARTÃO", fontWeight = FontWeight.Bold, fontSize = 22.sp)

                            Spacer(modifier = Modifier.height(30.dp))
                            Text(text = "NOME NO CARTÃO", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFD9D9D9)),
                                value = nomeCartao ?: "",
                                onValueChange = { nomeCartao = it },
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = "NÚMERO DO CARTÃO", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFD9D9D9)),
                                value = numeroCartao ?: "",
                                onValueChange = { numeroCartao = it },
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            Text(text = "DATA DE VALIDADE", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFD9D9D9)),
                                value = dataValidade ?: "",
                                onValueChange = { dataValidade = it },
                            )
                        }

                    }



                }


                else -> Unit
            }





        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen(navHostController = null)
}
