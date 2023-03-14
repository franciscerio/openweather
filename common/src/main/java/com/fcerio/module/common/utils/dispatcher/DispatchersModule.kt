package com.fcerio.module.common.utils.dispatcher

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Provides
    @Singleton
    fun providesDispatcherSource(): DispatcherProvider =
        object : DispatcherProvider {
            override val default: CoroutineDispatcher = Dispatchers.Default
            override val io: CoroutineDispatcher = Dispatchers.IO
            override val ui: CoroutineDispatcher = Dispatchers.Main
            override val uiImmediate: CoroutineDispatcher = Dispatchers.Main.immediate
        }
}
