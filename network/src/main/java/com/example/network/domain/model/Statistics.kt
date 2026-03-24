package com.example.network.domain.model

//24.03.2026
//Алексей
//модель статистики
data class Statistics(
    val id: Int = 0,
    val createdAt: String = "",
    val gameId: Int = 0,
    val result: String = "",
    val userId: String = "",
    val totalWinning: Int = 0
)
