package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.Coordinates

data class CoordinatesDTO(
    val lon: Double,
    val lat: Double
)

fun CoordinatesDTO.toDomain(): Coordinates {
    return with(this) {
        Coordinates(
            lon = lon,
            lat = lat
        )
    }
}