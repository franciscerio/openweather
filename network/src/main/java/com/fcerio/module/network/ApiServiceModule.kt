package com.fcerio.module.network

import com.fcerio.module.network.features.auth.AuthApiServices
import com.fcerio.module.network.features.weather.WeatherApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    @Singleton
    fun providesAuthApiServices(@Named("OPEN_WEATHER_APP") retrofit: Retrofit): AuthApiServices =
        retrofit.create(AuthApiServices::class.java)

    @Provides
    @Singleton
    fun providesWeatherApiServices(@Named("OPEN_WEATHER_API") retrofit: Retrofit): WeatherApiServices =
        retrofit.create(WeatherApiServices::class.java)

}
