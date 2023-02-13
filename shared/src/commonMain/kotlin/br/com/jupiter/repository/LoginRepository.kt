package br.com.jupiter.repository


import br.com.jupiter.model.Login
import br.com.jupiter.network.API
import kotlinx.coroutines.flow.flow


class LoginRepository(private val api: API = API.instance) {

    fun login(login: Login) = flow {
        API.token = api.login(login).token
        emit(API.token)
    }

    companion object {
        val instance by lazy { LoginRepository() }
    }

}