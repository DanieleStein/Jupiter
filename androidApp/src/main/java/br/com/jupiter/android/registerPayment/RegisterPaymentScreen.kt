package br.com.jupiter.android.registerPayment

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
import br.com.jupiter.android.MyApplicationTheme
import br.com.jupiter.android.components.BottomBar
import br.com.jupiter.android.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPaymentScreen(
    onNextButtonClicked: () -> Unit,
) {

    val nomeCartao = remember { mutableStateOf(TextFieldValue()) }
    val numeroCartao = remember { mutableStateOf(TextFieldValue()) }
    val dataValidade = remember { mutableStateOf(TextFieldValue()) }
    val codSeguranca = remember { mutableStateOf(TextFieldValue()) }

    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBar(title = "JUPITER") },
            bottomBar = {
                BottomBar(
                    title = "CONTINUAR", onClick = {
                        onNextButtonClicked.invoke()
                    }
                )
            }
        ) {

            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {


                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Passo 2 de 3", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "DADOS DE PAGAMENTO", fontWeight = FontWeight.Bold, fontSize = 22.sp)

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9)),
                    label = { Text(text = "Nome Cartão") },
                    value = nomeCartao.value,
                    onValueChange = { nomeCartao.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9)),
                    label = { Text(text = "Número do Cartão") },
                    value = numeroCartao.value,
                    onValueChange = { numeroCartao.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9)),
                    label = { Text(text = "Data de Validade") },
                    value = dataValidade.value,
                    onValueChange = { dataValidade.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD9D9D9)),
                    label = { Text(text = "Código de Segurança") },
                    value = codSeguranca.value,
                    onValueChange = { codSeguranca.value = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }
    }
}

@Preview
@Composable
fun RegisterPaymentScreenPreview() {
    RegisterPaymentScreen() {}
}
