package com.example.network.domain.repository

import com.example.network.domain.model.Game

//24.03.2026
//Алексей
//репозиторий для игр
interface GameRepository {
    suspend fun createGame(game: Game)
    suspend fun getGames(): List<Game>
    suspend fun getGameInfo(id: Int): Game
    suspend fun getLastWeekCreatedGames(id: String): List<Game>
}