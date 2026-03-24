package com.example.network.domain.usecase

import com.example.network.domain.repository.AuthRepository

//24.03.2026
//Алексей
//usecase для авторизации
class SignInUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): String{
        return authRepository.signIn(email, password)
    }
}