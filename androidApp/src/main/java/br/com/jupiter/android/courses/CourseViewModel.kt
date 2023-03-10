package br.com.jupiter.android.courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jupiter.model.Curso
import br.com.jupiter.model.Login
import br.com.jupiter.network.API
import br.com.jupiter.repository.CursoRepository
import br.com.jupiter.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CourseViewModel(
    val repository: CursoRepository = CursoRepository.instance
) : ViewModel() {

    private val _cursos = MutableStateFlow<DataResult<List<Curso>>>(DataResult.Empty)
    val cursos: StateFlow<DataResult<List<Curso>>> = _cursos

    init {
        getCursos()
    }

/*    fun login() = viewModelScope.launch {
        API.token = API.instance.login(
            Login(email = "jamtibaes@yahoo.com.brr", senha = "1234")
        ).token
    }.invokeOnCompletion {
        getCursos()
    }*/

    fun getCursos() = viewModelScope.launch {
        repository.getCursos().collectLatest {
            _cursos.value = it
        }
    }

}