package br.com.jupiter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform