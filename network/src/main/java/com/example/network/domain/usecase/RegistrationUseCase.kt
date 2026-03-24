package com.example.network.domain.usecase

import com.example.network.domain.repository.AuthRepository

//24.03.2026
//Алексей
//usecase для регистрации
class RegistrationUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): String{
        return authRepository.registration(email, password)
    }
}