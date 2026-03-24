package com.example.network.domain.repository

//24.03.2026
//Алексей
//репозиторий для авторизации и регистрации
interface AuthRepository {
    suspend fun signIn(inputEmail: String, inputPassword: String): String
    suspend fun registration(inputEmail: String, inputPassword: String): String
    suspend fun logout()
}