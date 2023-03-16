package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.Clouds

data class CloudsDTO(
    val all: Int
)

fun CloudsDTO.toDomain(): Clouds {
    return with(this) {
        Clouds(
            all = all
        )
    }
}