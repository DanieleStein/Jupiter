package br.com.jupiter.repository

import br.com.jupiter.model.Conteudo
import br.com.jupiter.network.API
import kotlinx.coroutines.flow.flow

class ContentRepository(private val api: API = API.instance) {

    suspend fun getContent(id: Long) = flow<List<Conteudo>> {
        emit(api.getContent(id).conteudo)
    }

    companion object {
        val instance by lazy { ContentRepository() }
    }

}