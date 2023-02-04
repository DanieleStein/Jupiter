package br.com.jupiter.model

data class Criador(
    val id: Long,
    val nome: String,
    val email: String,
    val senha: String,
    val curso: MutableList<Curso>?
)
