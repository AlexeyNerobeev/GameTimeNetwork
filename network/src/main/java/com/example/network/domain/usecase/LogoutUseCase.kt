package com.example.network.domain.usecase

import com.example.network.domain.repository.AuthRepository

//24.03.2026
//Алексей
//usecase для выхода
class LogoutUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(){
        authRepository.logout()
    }
}