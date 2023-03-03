package br.com.jupiter.android.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jupiter.model.Usuario
import br.com.jupiter.repository.LoginRepository
import br.com.jupiter.repository.UsuarioRepository
import br.com.jupiter.util.DataResult

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProfileViewModel(
    private val repository: UsuarioRepository = UsuarioRepository.instance
) : ViewModel() {
    private val _content = MutableStateFlow<DataResult<Usuario>>(DataResult.Empty)
    val content : StateFlow<DataResult<Usuario>> = _content

    init {
        getAll()
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll().collectLatest {
            _content.value = it
        }
    }

}