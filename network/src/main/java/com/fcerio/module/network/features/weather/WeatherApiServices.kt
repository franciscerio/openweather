package com.fcerio.module.network.features.weather

import com.fcerio.module.network.features.weather.models.CurrentWeatherDTO
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface WeatherApiServices {

    @GET("weather")
    suspend fun getCurrentWeather(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): CurrentWeatherDTO
}
