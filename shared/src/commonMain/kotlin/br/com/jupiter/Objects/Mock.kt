package br.com.jupiter.Objects

import br.com.jupiter.model.*

object Mock {

    val conteudo1: Conteudo = Conteudo(
        id = 1,
        titulo = "Onde guardar seu dinheiro?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo!",
        url = "https://youtube.com.br",
        ordemConteudo = 1
    )

    val conteudo2: Conteudo = Conteudo(
        id = 2,
        titulo = "Onde guardar seu dinheiro 2?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo! 2",
        url = "https://youtube.com.br",
        ordemConteudo = 2
    )

    val conteudo3: Conteudo = Conteudo(
        id = 3,
        titulo = "Onde guardar seu dinheiro 3?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo! 3",
        url = "https://youtube.com.br",
        ordemConteudo = 3
    )

    val conteudo4: Conteudo = Conteudo(
        id = 4,
        titulo = "Onde guardar seu dinheiro 4?",
        descricao = "Confira aqui as melhores formas de guardar seu dinheiro de forma que te traga grandes rendimentos a longo e curto prazo! 4",
        url = "https://youtube.com.br",
        ordemConteudo = 4
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
        curso = Categorias.RENDA_VARIAVEL,
        titulo = "Curso sobre Fundo Imobiliário",
        descricao = "Esse curso ensina sobre Fundo Imobiliário",
        conteudo = listaDeConteudo,
        criador = criador
    )

    val listaDeCursos: List<Curso> = listOf(
        curso1, curso2, curso3
    )

    val cartao: Cartao = Cartao(
        id = 1,
        nomeCartao = "Daniele Stein",
        numeroCartao = "1234.1234.1234.1234",
        codSeguranca = "123",
        dataValidade = "01/01/2030",
        usuario = null
    )


    val usuario: Usuario = Usuario(
        id = 1,
        nome = "Daniele Stein",
        email = "dani@email.com.br",
        senha = "1234",
        cpf = "123.456.789-00",
        dataNascimento = "01/01/2000",
        cartao = listOf(cartao),
        pedido = null
    )

    val pedido: Pedido = Pedido(
        id = 1,
        periodoContratadoMeses = 12,
        dataInicial = "01/03/2023",
        valor = 25.0,
        usuario = usuario
    )

    val listaVideos: List<String> = listOf(
        "https://cdn.coverr.co/videos/coverr-a-man-counting-money-9403/1080p.mp4",
        "https://cdn.coverr.co/videos/coverr-a-trader-writing-something-in-a-notebook-7909/1080p.mp4",
        "https://cdn.coverr.co/videos/coverr-opening-an-nft-image-on-the-opensea-marketplace-9724/1080p.mp4",
        "https://cdn.coverr.co/videos/coverr-a-girl-searches-for-nft-data-using-her-laptop-and-a-smartphone-app-7544/1080p.mp4"
    )


}