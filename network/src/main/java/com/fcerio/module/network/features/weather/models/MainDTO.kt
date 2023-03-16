package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.Main

data class MainDTO(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)

fun MainDTO.toDomain(): Main {
    return with(this) {
        Main(
            temp = temp,
            feelsLike = feelsLike,
            tempMin = tempMin,
            tempMax = tempMax,
            pressure = pressure,
            humidity = humidity
        )
    }
}