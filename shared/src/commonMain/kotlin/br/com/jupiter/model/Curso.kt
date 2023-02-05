package br.com.jupiter.model

data class Curso(
    val id: Long,
    val curso: String,
    val titulo: String,
    val descricao: String,
    val conteudo: List<Conteudo>?,
    val criador: Criador?
)