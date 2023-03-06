package br.com.jupiter.model
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val id: Long,
    val nome: String,
    val email: String,
    val senha: String,
    val cpf: String,
    val dataNascimento: String,
    val cartao: List<Cartao>?,
    val pedido: List<Pedido>?
)
