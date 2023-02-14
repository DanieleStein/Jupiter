package br.com.jupiter.repository


import br.com.jupiter.model.Login
import br.com.jupiter.network.API
import br.com.jupiter.network.Token
import br.com.jupiter.util.DataResult
import br.com.jupiter.util.updateStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LoginRepository(private val api: API = API.instance) {

    suspend fun getToken(login: Login) = flow<DataResult<Token>> {
        val chamada: Token = api.login(login)

        if (chamada.email == login.email) {
            API.token = chamada.token
            emit(DataResult.Success(chamada))
        } else {
            emit(DataResult.Empty)
        }

    }.updateStates().flowOn(Dispatchers.Default)

    companion object {
        val instance by lazy { LoginRepository() }
    }

}