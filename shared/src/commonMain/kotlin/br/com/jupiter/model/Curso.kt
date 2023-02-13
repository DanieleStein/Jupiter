package br.com.jupiter.model

import kotlinx.serialization.Serializable

@Serializable
data class Curso(
    val id: Long,
    val curso: Categorias, //categoria
    val titulo: String,
    val descricao: String,

    val conteudo: List<Conteudo>?,
    val criador: Criador?
)

 enum class Categorias(val nome: String) {
    FINANCAS("FINANÇAS"), RENDA_VARIAVEL("RENDA VARIÁVEL"), RENDA_FIXA("RENDA FIXA")
}

