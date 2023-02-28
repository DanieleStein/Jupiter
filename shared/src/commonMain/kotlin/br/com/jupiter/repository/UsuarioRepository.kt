package br.com.jupiter.repository

import br.com.jupiter.model.Usuario
import br.com.jupiter.network.API
import br.com.jupiter.util.DataResult
import br.com.jupiter.util.updateStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UsuarioRepository(private val api: API = API.instance) {

    suspend fun getAll() = flow {
        val result = api.getUsuario()

        val usuario: Usuario = result.filter { user -> user.email == API.email }.first()

        if (result.isEmpty()){
            emit(DataResult.Empty)
        } else {
            emit(DataResult.Success(usuario))
        }

    }.updateStates().flowOn(Dispatchers.Default)

    companion object {
        val instance by lazy { UsuarioRepository() }
    }


}