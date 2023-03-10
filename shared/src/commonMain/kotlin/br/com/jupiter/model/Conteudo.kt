package br.com.jupiter.model

import kotlinx.serialization.Serializable

@Serializable
data class Conteudo(
    val id: Long,
    val titulo: String,
    val descricao: String,
    val url: String,
    val ordemConteudo: Long
)

@Serializable
data class ConteudoResponse(val conteudo: List<Conteudo>)