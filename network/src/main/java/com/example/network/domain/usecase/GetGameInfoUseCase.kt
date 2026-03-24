package com.example.network.domain.usecase

import com.example.network.domain.model.Game
import com.example.network.domain.repository.GameRepository

//24.03.2026
//Алексей
//usecase для получения информации об игре
class GetGameInfoUseCase(private val gameRepository: GameRepository) {
    suspend operator fun invoke(id: Int): Game{
        return gameRepository.getGameInfo(id)
    }
}