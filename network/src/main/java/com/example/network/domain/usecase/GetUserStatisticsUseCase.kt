package com.example.network.domain.usecase

import com.example.network.domain.model.Statistics
import com.example.network.domain.repository.StatisticsRepository

//24.03.2026
//Алексей
//usecase для получения статистики пользователя
class GetUserStatisticsUseCase(private val statisticsRepository: StatisticsRepository) {
    suspend operator fun invoke(id: String): List<Statistics>{
        return statisticsRepository.getUserStatistics(id)
    }
}