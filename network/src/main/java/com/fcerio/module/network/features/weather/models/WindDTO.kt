package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.Wind

data class WindDTO(
    val speed: Int,
    val deg: Int
)

fun WindDTO.toDomain(): Wind {
    return with(this) {
        Wind(
            speed = speed,
            deg = deg
        )
    }
}