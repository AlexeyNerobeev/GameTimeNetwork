package com.example.network.data.mappers

import com.example.network.data.dto.UserDto
import com.example.network.domain.model.User

//24.03.2026
//Алексей
//мапперы для модели пользователя
internal fun User.toDto() = UserDto(
    id = id,
    full_name = fullName,
    user_name = userName,
    phone = phone,
    email = email,
    user_id = userId
)

internal fun UserDto.toModel() = User(
    id = id,
    fullName = full_name,
    userName = user_name,
    phone = phone,
    email = email,
    userId = user_id
)