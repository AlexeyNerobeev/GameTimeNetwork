package com.example.network.data.mappers

import com.example.network.data.dto.StatisticsDto
import com.example.network.domain.model.Statistics

internal fun Statistics.toDto() = StatisticsDto(
    id = id,
    created_at = createdAt,
    game_id = gameId,
    result = result,
    user_id = userId,
    total_winning = totalWinning
)

internal fun StatisticsDto.toModel() = Statistics(
    id = id,
    createdAt = created_at,
    gameId = game_id,
    result = result,
    userId = user_id,
    totalWinning = total_winning
)