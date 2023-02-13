package br.com.jupiter.network

@kotlinx.serialization.Serializable
data class Token(val token: String, val email: String, val senha: String)
