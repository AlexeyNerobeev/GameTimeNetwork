package com.example.network.data.dto

import kotlinx.serialization.Serializable

//24.03.2026
//Алексей
//dto для модели пользователя
@Serializable
data class UserDto(
    val id: Int = 0,
    val full_name: String = "",
    val user_name: String = "",
    val phone: String = "",
    val email: String = "",
    val user_id: String = ""
)