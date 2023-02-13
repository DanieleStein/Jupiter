package br.com.jupiter.repository

import br.com.jupiter.model.Curso
import br.com.jupiter.network.API
import kotlinx.coroutines.flow.flow

class CursoRepository(private val api: API = API.instance) {

    suspend fun getCursos() = flow<List<Curso>> {
        val chamadaAPI = api.getCourses()
        emit(chamadaAPI)
    }

    companion object {
        val instance by lazy { CursoRepository() }
    }

}