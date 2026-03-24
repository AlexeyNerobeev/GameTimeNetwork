package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.StatisticsDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.supabase.Connect.supabase
import com.example.network.domain.model.Statistics
import com.example.network.domain.repository.StatisticsRepository
import io.github.jan.supabase.postgrest.postgrest

//24.03.2026
//Алексей
//реализация репозитория статистики
class StatisticsRepositoryImpl: StatisticsRepository {
    //метод для сохранения результата игры. Принимает модель статистики
    override suspend fun saveGameResult(statistics: Statistics) {
        try {
            supabase.postgrest["statistics"].insert(statistics.toDto())
        } catch (e: Exception) {
            Log.e("saveGameResult", e.message.toString())
        }
    }

    //метод для получения статистики пользователя. Принимает id пользователя. Возвращает список записей результатов игр
    override suspend fun getUserStatistics(id: String): List<Statistics> {
        try {
            val request = supabase.postgrest["statistics"].select {
                filter {
                    and {
                        eq("user_id", id)
                    }
                }
            }.decodeList<StatisticsDto>()
            Log.d("getUseStatistics", request.toString())
            return request.map { it.toModel() }
        } catch (e: Exception) {
            Log.e("getUserStatistics", e.message.toString())
            return listOf()
        }
    }
}