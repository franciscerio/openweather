package com.fcerio.module.data.features.weather

import com.fcerio.module.domain.weather.CurrentWeather
import com.fcerio.module.network.features.weather.WeatherRemoteSource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteSource: WeatherRemoteSource
) : WeatherRepository {

    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather {
        return weatherRemoteSource.getCurrentWeather(latitude, longitude)
    }
}