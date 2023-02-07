package br.com.jupiter.model

data class Conteudo(
    val id: Long,
    val titulo: String,
    val descricao: String,
    val url: String,
    val ordemConteudo: Long,
    val curso: Curso?
)
