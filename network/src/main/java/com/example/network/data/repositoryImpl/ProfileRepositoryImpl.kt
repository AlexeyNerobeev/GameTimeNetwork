package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.UserDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.supabase.Connect.supabase
import com.example.network.domain.model.User
import com.example.network.domain.repository.ProfileRepository
import io.github.jan.supabase.postgrest.postgrest

//24.03.2026
//Алексей
//реализация репозитория для работы с профилем
class ProfileRepositoryImpl: ProfileRepository {
    //метод для создания профиля. Принимает модель пользователя
    override suspend fun createProfile(user: User) {
        try {
            supabase.postgrest["profile"].insert(user.toDto())
        } catch (e: Exception) {
            Log.e("createProfile", e.message.toString())
        }
    }

    //метод для редактирования профиля. Принимает модель пользователя
    override suspend fun editProfile(user: User) {
        try {
            supabase.postgrest["profile"].update(user.toDto()) {
                filter {
                    and {
                        eq("user_id", user.userId)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("editProfile", e.message.toString())
        }
    }

    //метод для получения профиля. Принимает модель пользователя. Возвращет модель пользователя
    override suspend fun getProfile(id: String): User {
        try {
            val profile = supabase.postgrest["profile"].select {
                filter {
                    and {
                        eq("user_id", id)
                    }
                }
            }.decodeSingle<UserDto>().toModel()
            Log.d("getProfile", profile.toString())
            return profile
        }catch (e: Exception){
            Log.e("getProfile", e.message.toString())
            return User()
        }
    }
}