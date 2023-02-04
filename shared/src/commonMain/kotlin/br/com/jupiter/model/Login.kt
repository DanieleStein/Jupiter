package br.com.jupiter.model

data class Login(
    private val email: String,
    private val senha: String
) {
    fun validacao(): Boolean = (email == "abc@123" && senha == "1234")
}