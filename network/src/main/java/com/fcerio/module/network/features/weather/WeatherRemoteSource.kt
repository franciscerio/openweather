package com.fcerio.module.network.features.weather

import com.fcerio.module.domain.weather.CurrentWeather

interface WeatherRemoteSource {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather
}