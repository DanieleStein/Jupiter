package br.com.jupiter.model

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val email: String,
    private val senha: String
) {

}
