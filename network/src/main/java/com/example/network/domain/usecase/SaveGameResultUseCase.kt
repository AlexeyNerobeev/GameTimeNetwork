package com.example.network.domain.usecase

import com.example.network.domain.model.Statistics
import com.example.network.domain.repository.StatisticsRepository

//24.03.2026
//Алексей
//usecase для сохранения результата игры
class SaveGameResultUseCase(private val statisticsRepository: StatisticsRepository) {
    suspend operator fun invoke(statistics: Statistics){
        statisticsRepository.saveGameResult(statistics)
    }
}