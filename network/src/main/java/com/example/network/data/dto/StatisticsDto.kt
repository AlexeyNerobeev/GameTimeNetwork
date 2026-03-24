package com.example.network.data.dto

import kotlinx.serialization.Serializable

//24.03.2026
//Алексей
//dto для модели статистики
@Serializable
data class StatisticsDto (
    val id: Int = 0,
    val created_at: String = "",
    val game_id: Int = 0,
    val result: String = "",
    val user_id: String = "",
    val total_winning: Int = 0
)