package br.com.jupiter.model
import kotlinx.serialization.Serializable

@Serializable
data class Criador(
    val id: Long,
    val nome: String,
    val email: String,
    val senha: String,
    val curso: MutableList<Curso>?
)
