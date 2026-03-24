package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.supabase.Connect.supabase
import com.example.network.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

//24.03.2026
//Алексей
//класс реализации репозитория авторизации
class AuthRepositoryImpl: AuthRepository {
    //метод для авторизации. Принимает почту и пароль пользователя. Возвращает id пользователя
    override suspend fun signIn(inputEmail: String, inputPassword: String): String {
        try {
            supabase.auth.signInWith(Email){
                email = inputEmail
                password = inputPassword
            }
            Log.d("signIn", getUserId())
            return getUserId()
        } catch (e: Exception) {
            Log.e("signIn", e.message.toString())
            return ""
        }
    }

    //метод для регистрации. Принимает почту и пароль пользователя. Возвращает id пользователя
    override suspend fun registration(
        inputEmail: String,
        inputPassword: String
    ): String {
        try {
            supabase.auth.signUpWith(Email){
                email = inputEmail
                password = inputPassword
            }
            Log.d("registration", getUserId())
            return getUserId()
        } catch (e: Exception) {
            Log.e("registration", e.message.toString())
            return ""
        }
    }

    //метод для выхода
    override suspend fun logout() {
        supabase.auth.signOut()
    }

    //метод для получения id пользователя. Возвращает id пользователя
    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }
}