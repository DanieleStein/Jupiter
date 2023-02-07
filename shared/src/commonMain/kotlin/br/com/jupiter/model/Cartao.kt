package br.com.jupiter.model


data class Cartao(
    val id: Long,
    val nomeCartao: String,
    val numeroCartao: String,
    val codSeguranca: String,
    val dataValidade: String,
    val usuario: Usuario
) {

}