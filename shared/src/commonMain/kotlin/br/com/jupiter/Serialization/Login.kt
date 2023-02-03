package br.com.jupiter.Serialization

import kotlinx.serialization.Serializable

@Serializable
data class Login(
  val email: String,
  val senha: String
)
