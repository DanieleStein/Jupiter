package br.com.jupiter.model

data class Usuario(
    val id: Long,
    val nome: String,
    val email: String,
    val senha: String,
    val cpf: String,
    val dataNascimento: String,
    val cartao: MutableList<Cartao>?,
    val pedido: MutableList<Pedido>?
)