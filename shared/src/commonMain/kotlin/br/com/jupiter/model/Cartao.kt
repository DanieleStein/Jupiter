package br.com.jupiter.model

import kotlinx.serialization.Serializable

@Serializable
data class Cartao(
    val id: Long,
    val nomeCartao: String,
    val numeroCartao: String,
    val codSeguranca: String,
    val dataValidade: String,
    val usuario: Usuario? = null
)