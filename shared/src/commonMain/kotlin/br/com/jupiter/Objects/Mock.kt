package br.com.jupiter.Objects

import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Conteudo
import br.com.jupiter.model.Criador
import br.com.jupiter.model.Curso

object Mock {

    val conteudo1: Conteudo = Conteudo(
        id = 1,
        titulo = "Onde guardar seu dinheiro?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo!",
        url = "https://youtube.com.br",
        ordemConteudo = 1,
        curso = null
    )

    val conteudo2: Conteudo = Conteudo(
        id = 2,
        titulo = "Onde guardar seu dinheiro 2?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo! 2",
        url = "https://youtube.com.br",
        ordemConteudo = 2,
        curso = null
    )

    val conteudo3: Conteudo = Conteudo(
        id = 3,
        titulo = "Onde guardar seu dinheiro 3?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo! 3",
        url = "https://youtube.com.br",
        ordemConteudo = 3,
        curso = null
    )

    val conteudo4: Conteudo = Conteudo(
        id = 4,
        titulo = "Onde guardar seu dinheiro 4?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo! 4",
        url = "https://youtube.com.br",
        ordemConteudo = 4,
        curso = null
    )



    val criador: Criador = Criador(
        id = 1,
        nome = "Jose",
        email = "jose@email.com.br",
        senha = "1234",
        curso = null
    )

    val listaDeConteudo: List<Conteudo> = listOf(
        conteudo1, conteudo2, conteudo3, conteudo4
    )

    val curso1: Curso = Curso(
        id = 1,
        curso = Categorias.FINANCAS,
        titulo = "Curso sobre Finanças",
        descricao = "Esse curso ensina sobre finanças",
        conteudo = listaDeConteudo,
        criador = criador
    )

    val curso2: Curso = Curso(
        id = 2,
        curso = Categorias.FINANCAS,
        titulo = "Curso sobre Finanças Empresarial",
        descricao = "Esse curso ensina sobre finanças Empresarial",
        conteudo = listaDeConteudo,
        criador = criador
    )

    val curso3: Curso = Curso(
        id = 3,
        curso = Categorias.FII,
        titulo = "Curso sobre Fundo Imobiliário",
        descricao = "Esse curso ensina sobre Fundo Imobiliário",
        conteudo = listaDeConteudo,
        criador = criador
    )

    val listaDeCursos: List<Curso> = listOf(
        curso1, curso2, curso3
    )


}