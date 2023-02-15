package br.com.jupiter.repository

import br.com.jupiter.network.API
import br.com.jupiter.util.DataResult
import br.com.jupiter.util.updateStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CursoRepository(private val api: API = API.instance) {

    /*suspend fun getCursos() = flow<List<Curso>> {
        //emit(emptyList())
        emit(api.getCourses())
    }.flowOn(Dispatchers.Default)*/


    suspend fun getCursos() = flow {
        val chamada = api.getCourses()
        if (chamada.isEmpty()){
            emit(DataResult.Empty)
        } else {
            emit(DataResult.Success(chamada))
        }
    }.updateStates().flowOn(Dispatchers.Default)

    companion object {
        val instance by lazy { CursoRepository() }
    }

}