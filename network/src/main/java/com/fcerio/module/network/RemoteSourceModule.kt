package com.fcerio.module.network

import com.fcerio.module.network.features.auth.AuthRemoteSource
import com.fcerio.module.network.features.auth.AuthRemoteSourceImpl
import com.fcerio.module.network.features.weather.WeatherRemoteSource
import com.fcerio.module.network.features.weather.WeatherRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteSourceModule {

    @Binds
    @Singleton
    fun providesAuthRemoteSource(remoteSourceImpl: AuthRemoteSourceImpl): AuthRemoteSource

    @Binds
    @Singleton
    fun providesWeatherRemoteSource(remoteSourceImpl: WeatherRemoteSourceImpl): WeatherRemoteSource
}
