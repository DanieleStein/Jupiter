package br.com.jupiter.network

import br.com.jupiter.Objects.Mock
import br.com.jupiter.model.Categorias
import br.com.jupiter.model.Curso
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Network {


    fun loadHome() {
        val cursos: MutableList<Curso> = MutableList(5) { Curso(
            id = 1,
            curso = Categorias.FINANCAS,
            titulo = "Curso sobre Finanças",
            descricao = "Esse curso ensina sobre finanças",
            conteudo = Mock.listaDeConteudo,
            criador = Mock.criador
        ) }

        /*val data = Json.encodeToString(cursos)
        val desc = Json.decodeFromString<List<Curso>>(data)

        desc.map {
            println(it.id)
        }*/

    }


}