package com.example.network.domain.usecase

import com.example.network.domain.model.User
import com.example.network.domain.repository.ProfileRepository

//24.03.2026
//Алексей
//usecase для создания профиля
class CreateProfileUseCase(private val profileRepository: ProfileRepository) {
    suspend operator fun invoke(user: User){
        profileRepository.createProfile(user)
    }
}