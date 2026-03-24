package com.example.network.data.mappers

import com.example.network.data.dto.GameDto
import com.example.network.domain.model.Game
import kotlin.Int

internal fun Game.toDto() = GameDto(
    id = id,
    name = name,
    category = category,
    wining_price = winingPrice,
    date_start = dateStart,
    date_end = dateEnd,
    description = description,
    user_id = userId,
    status = status,
    created_at = createdAt
)

internal fun GameDto.toModel() = Game(
    id = id,
    name = name,
    category = category,
    winingPrice = wining_price,
    dateStart = date_start,
    dateEnd = date_end,
    description = description,
    userId = user_id,
    status = status,
    createdAt = created_at
)