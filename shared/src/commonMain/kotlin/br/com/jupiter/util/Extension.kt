package br.com.jupiter.util

import io.ktor.utils.io.errors.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

sealed class DataResult<out T: Any> {
    data class Success<out T: Any>(val data: T) : DataResult<T>()
    data class Error(val error: Throwable) : DataResult<Nothing>()
    data class Loading(val isLoading: Boolean) : DataResult<Nothing>()
    object Empty : DataResult<Nothing>()
}

fun <T : Any> Flow<DataResult<T>>.updateStates() =

    retryWhen { cause, attempt ->
        if (cause is IOException && attempt < 3) {
            delay(2000)
            true
        } else {
            false
        }
    }
    .onStart { emit(DataResult.Loading(isLoading = true)) }
    .catch { emit(DataResult.Error(it)) }
    //.onCompletion { emit(DataResult.Loading(isLoading = false)) }