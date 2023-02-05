package br.com.jupiter.model

data class Pedido(
    val id: Long,
    val periodoContratadoMeses: Int,
    val dataInicial: String,
    val valor: Double,
    val usuario: Usuario?
)