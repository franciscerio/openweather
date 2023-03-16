package com.fcerio.module.data.features.weather

import com.fcerio.module.domain.weather.CurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather
}