package br.com.jupiter.android.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jupiter.model.Login
import br.com.jupiter.util.DataResult
import br.com.jupiter.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class LoginViewModel(
    private val repository: LoginRepository = LoginRepository.instance
) : ViewModel() {

    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token

    /*fun loginFunction(login: Login) = viewModelScope.launch {
        repository.login(login).collectLatest {
            _token.value = it
        }
    }*/

}