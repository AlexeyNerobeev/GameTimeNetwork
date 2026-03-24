package com.example.network.domain.model

//24.03.2026
//Алексей
//модель игры
data class Game(
    val id: Int = 0,
    val name: String = "",
    val category: String = "",
    val winingPrice: Int = 0,
    val dateStart: String = "",
    val dateEnd: String = "",
    val description: String = "",
    val userId: String = "",
    val status: String = "",
    val createdAt: String = ""
)
