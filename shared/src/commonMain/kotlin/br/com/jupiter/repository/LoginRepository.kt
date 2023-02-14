package br.com.jupiter.repository


import br.com.jupiter.model.Login
import br.com.jupiter.network.API
import br.com.jupiter.util.DataResult
import br.com.jupiter.util.updateStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LoginRepository(private val api: API = API.instance) {

    /*suspend fun getToken(login: Login) = flow<DataResult<String>> {
        API.token = api.login(login).token
        if (API.token == ""){
            emit( DataResult.Empty )
        } else {
            emit(DataResult.Success(API.token))
        }
    }.updateStates().flowOn(Dispatchers.Default)*/

    suspend fun getToken(login: Login) = flow {
        API.token = api.login(login).token
        emit(DataResult.Success(API.token))
    }.updateStates().flowOn(Dispatchers.Default)

    companion object {
        val instance by lazy { LoginRepository() }
    }

}