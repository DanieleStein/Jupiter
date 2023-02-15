package br.com.jupiter.repository

import br.com.jupiter.network.API
import br.com.jupiter.util.DataResult
import br.com.jupiter.util.updateStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ContentRepository(private val api: API = API.instance) {


    suspend fun getContent(id: Long) = flow {
        val chamada = api.getContent(id).conteudo
        if (chamada.isEmpty()) {
            emit(DataResult.Empty)
        } else {
            emit(DataResult.Success(chamada))
        }
    }.updateStates().flowOn(Dispatchers.Default)


    companion object {
        val instance by lazy { ContentRepository() }
    }

}