package com.fcerio.module.network.features.weather

import com.fcerio.module.domain.weather.CurrentWeather
import com.fcerio.module.network.BuildConfig
import com.fcerio.module.network.base.BaseRemoteSource
import com.fcerio.module.network.features.weather.models.toDomain
import javax.inject.Inject

class WeatherRemoteSourceImpl @Inject constructor(
    private val apiServices: WeatherApiServices
) : BaseRemoteSource(), WeatherRemoteSource {
    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather {
        val map = mutableMapOf<String, Any>()
        map["lat"] = latitude
        map["lon"] = longitude
        map["appid"] = BuildConfig.OPEN_WEATHER_API_KEY

        return apiServices.getCurrentWeather(map).toDomain()
    }

}