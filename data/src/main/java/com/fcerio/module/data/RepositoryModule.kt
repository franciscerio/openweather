package com.fcerio.module.data

import com.fcerio.module.data.features.auth.AuthRepository
import com.fcerio.module.data.features.auth.AuthRepositoryImpl
import com.fcerio.module.data.features.weather.WeatherRepository
import com.fcerio.module.data.features.weather.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun providesAuthRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    fun providesWeatherRepository(repositoryImpl: WeatherRepositoryImpl): WeatherRepository

}
