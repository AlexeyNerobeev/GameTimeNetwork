package com.example.network.domain.usecase

import com.example.network.domain.model.Game
import com.example.network.domain.repository.GameRepository

//24.03.2026
//Алексей
//usecase для создания игры
class CreateGameUseCase(private val gameRepository: GameRepository) {
    suspend operator fun invoke(game: Game){
        gameRepository.createGame(game)
    }
}