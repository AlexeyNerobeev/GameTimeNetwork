package com.example.network.domain.model

//24.03.2026
//Алексей
//модель пользователя
data class User(
    val id: Int = 0,
    val fullName: String = "",
    val userName: String = "",
    val phone: String = "",
    val email: String = "",
    val userId: String = ""
)
