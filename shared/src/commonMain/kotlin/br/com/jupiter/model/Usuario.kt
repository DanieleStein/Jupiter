package br.com.jupiter.model

data class Usuario(
    var id: Long,
    var nome: String,
    var email: String,
    var senha: String,
    var cpf: String,
    var dataNascimento: String,
    var cartao: List<Cartao>,
    var pedido: List<Pedido>
)