package br.com.jupiter.android.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jupiter.model.Conteudo
import br.com.jupiter.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContentViewModel(
    val repository: ContentRepository = ContentRepository.instance
) : ViewModel() {

    private val _contents = MutableStateFlow<List<Conteudo>>(emptyList())
    val contents: StateFlow<List<Conteudo>> = _contents

    fun getContent(id: Long) = viewModelScope.launch {
        repository.getContent(id).collectLatest {
            _contents.value = it
        }
    }

}