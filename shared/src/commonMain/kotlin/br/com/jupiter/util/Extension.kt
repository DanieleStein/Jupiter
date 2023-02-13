package br.com.jupiter.util

sealed class DataResult<out R> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val exception: Exception) : DataResult<Nothing>()
    data class Loading(val isLoading: Boolean) : DataResult<Nothing>()
    object Empty: DataResult<Nothing>()
}