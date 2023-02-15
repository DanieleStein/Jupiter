package br.com.jupiter.android.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jupiter.model.Conteudo
import br.com.jupiter.repository.ContentRepository
import br.com.jupiter.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContentViewModel(
    private val contentRepository: ContentRepository = ContentRepository.instance
) : ViewModel() {

    private val _contents = MutableStateFlow<DataResult<List<Conteudo>>>(DataResult.Empty)
    val contents: StateFlow<DataResult<List<Conteudo>>> = _contents

    fun getContent(id: Long) = viewModelScope.launch {
        contentRepository.getContent(id).collectLatest {
            _contents.value = it
        }
    }

}