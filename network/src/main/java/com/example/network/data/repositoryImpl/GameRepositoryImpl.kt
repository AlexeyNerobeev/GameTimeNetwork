package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.GameDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.supabase.Connect.supabase
import com.example.network.domain.model.Game
import com.example.network.domain.repository.GameRepository
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.days

//24.03.2026
//Алексей
//реализация репозитория игры
class GameRepositoryImpl: GameRepository {
    //метод для создания игры. Принимает модель игры
    override suspend fun createGame(game: Game) {
        try {
            supabase.postgrest["game"].insert(game.toDto())
        } catch (e: Exception) {
            Log.e("createGame", e.message.toString())
        }
    }

    //метод для получения списка игр. Возвращает список моделей игр
    override suspend fun getGames(): List<Game> {
        try {
            val request = supabase.postgrest["game"].select().decodeList<GameDto>()
            Log.d("getGames", request.toString())
            return request.map { it.toModel() }
        } catch (e: Exception) {
            Log.e("getGames", e.message.toString())
            return listOf()
        }
    }

    //метод для получения информации об игре. Принимает id игры. Возвращает модель игры
    override suspend fun getGameInfo(id: Int): Game {
        try {
            val request = supabase.postgrest["game"].select {
                filter {
                    and {
                        eq("id", id)
                    }
                }
            }.decodeSingle<GameDto>().toModel()
            Log.d("getGameInfo", request.toString())
            return request
        } catch (e: Exception) {
            Log.e("getGameInfo", e.message.toString())
            return Game()
        }
    }

    //метод для получения созданных игр за последнюю неделю. Принимает id пользователя. Возвращает список игр
    override suspend fun getLastWeekCreatedGames(id: String): List<Game> {
        try {
            val oneWeekAgo: Instant = Clock.System.now().minus(7.days)
            val request = supabase.postgrest["game"].select {
                filter {
                    and {
                        eq("user_id", id)
                        gte("created_at", oneWeekAgo.toString())
                    }
                }
            }.decodeList<GameDto>()
            Log.d("getLastWeekCreatedGames", request.toString())
            return request.map { it.toModel() }
        } catch (e: Exception) {
            Log.e("getLastWeekCreatedGames", e.message.toString())
            return listOf()
        }
    }
}