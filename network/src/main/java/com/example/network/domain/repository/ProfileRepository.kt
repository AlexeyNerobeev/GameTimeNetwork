package com.example.network.domain.repository

import com.example.network.domain.model.User

//24.03.2026
//Алексей
//репозиторий для работы с профилем пользовтеля
interface ProfileRepository {
    suspend fun createProfile(user: User)
    suspend fun editProfile(user: User)
    suspend fun getProfile(id: String): User
}