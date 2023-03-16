package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.CurrentWeather
import com.fcerio.module.domain.weather.Weather

data class WeatherDTO(
    val id: Int,
    val main: String,
    val description: String
)

fun WeatherDTO.toDomain(): Weather {
    return with(this) {
        Weather(
            id = id,
            main = main,
            description = description
        )
    }
}