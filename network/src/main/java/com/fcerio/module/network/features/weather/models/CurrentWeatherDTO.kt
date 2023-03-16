package com.fcerio.module.network.features.weather.models

import com.fcerio.module.domain.weather.CurrentWeather

data class CurrentWeatherDTO(
    val coordinates: CoordinatesDTO,
    val weather: List<WeatherDTO> = emptyList(),
    val base: String,
    val main: MainDTO,
    val visibility: Int,
    val wind: WindDTO,
    val clouds: CloudsDTO,
    val dt: Long,
    val sys: SysDTO,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int
)

fun CurrentWeatherDTO.toDomain(): CurrentWeather {
    return with(this) {
        CurrentWeather(
            coordinates = coordinates.toDomain(),
            weather = weather.map { it.toDomain() },
            base = base,
            main = main.toDomain(),
            visibility = visibility,
            wind = wind.toDomain(),
            clouds = clouds.toDomain(),
            dt = dt,
            sys = sys.toDomain(),
            timezone = timezone,
            id = id,
            name = name,
            cod = cod
        )
    }
}