package br.com.jupiter.model

enum class Categorias(nome: String) {
    FINANÇAS("Finanças"), FII("Fundo Imobiliário"),
}

data class Curso(
    val id: Long,
    val curso: Categorias, //categoria
    val titulo: String,
    val descricao: String,
    val conteudo: List<Conteudo>?,
    val criador: Criador?
)