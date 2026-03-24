package com.example.network.domain.usecase

import com.example.network.domain.model.Game
import com.example.network.domain.repository.GameRepository

//24.03.2026
//Алексей
//usecase для получения списка игр
class GetGamesUseCase(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<Game> {
        return gameRepository.getGames()
    }
}