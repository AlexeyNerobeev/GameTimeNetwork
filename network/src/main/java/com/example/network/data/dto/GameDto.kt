package com.example.network.data.dto

import kotlinx.serialization.Serializable

//24.03.2026
//Алексей
//dto для модели игры
@Serializable
data class GameDto(
    val id: Int = 0,
    val name: String = "",
    val category: String = "",
    val wining_price: Int = 0,
    val date_start: String = "",
    val date_end: String = "",
    val description: String = "",
    val user_id: String = "",
    val status: String = "",
    val created_at: String = ""
)