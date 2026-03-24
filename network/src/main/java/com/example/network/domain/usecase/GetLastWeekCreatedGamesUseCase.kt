package com.example.network.domain.usecase

import com.example.network.domain.model.Game
import com.example.network.domain.repository.GameRepository

//24.03.2026
//Алексей
//usecase для получения созданных за последнюю неделю игр
class GetLastWeekCreatedGamesUseCase(private val gameRepository: GameRepository) {
    suspend operator fun invoke(id: String): List<Game> {
        return gameRepository.getLastWeekCreatedGames(id)
    }
}