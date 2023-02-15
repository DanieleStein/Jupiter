package br.com.jupiter.network

import br.com.jupiter.model.Conteudo
import br.com.jupiter.model.ConteudoResponse
import br.com.jupiter.model.Curso
import br.com.jupiter.model.Login
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

class API {


    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false

                }
            )
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            header("Authorization", token)
        }
    }


    suspend fun login(login: Login): Token {
        return httpClient.post("${DEFAULT_URL}/usuario/login") {
            setBody(login)
        }.body()
    }

    suspend fun getCourses(): List<Curso> {
        return httpClient.get("${DEFAULT_URL}/curso").body()
    }

    suspend fun getContent(id: Long): ConteudoResponse {
        return httpClient.get("${DEFAULT_URL}/curso/id/${id}").body()
    }


    @ThreadLocal
    companion object {
        val instance by lazy { API() }
        var token = ""
        const val DEFAULT_URL = "https://app-jupiter.onrender.com"
    }


}