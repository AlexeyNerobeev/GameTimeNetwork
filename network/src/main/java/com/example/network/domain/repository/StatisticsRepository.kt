package com.example.network.domain.repository

import com.example.network.domain.model.Statistics

//24.03.2026
//Алексей
//репозиторий для работы со статистикой
interface StatisticsRepository {
    suspend fun saveGameResult(statistics: Statistics)
    suspend fun getUserStatistics(id: String): List<Statistics>
}