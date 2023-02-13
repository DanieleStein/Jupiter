package br.com.jupiter.model
import kotlinx.serialization.Serializable

@Serializable
data class Pedido(
    val id: Long,
    val periodoContratadoMeses: Int,
    val dataInicial: String,
    val valor: Double,
    val usuario: Usuario?
)