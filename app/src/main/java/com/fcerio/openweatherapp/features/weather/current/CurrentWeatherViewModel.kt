package com.fcerio.openweatherapp.features.weather.current

import androidx.lifecycle.viewModelScope
import com.fcerio.module.common.base.BaseStateViewModel
import com.fcerio.module.common.utils.launchWithTimber
import com.fcerio.module.data.features.weather.WeatherRepository
import com.fcerio.openweatherapp.features.weather.current.CurrentWeatherViewModel.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : BaseStateViewModel<ViewState, ActionState, ErrorState, Action>() {

    override val initialState: ViewState
        get() = ViewState(isLoading = true)

    init {
        viewModelScope.launchWithTimber {
            getCurrentWeather()
        }

        actionFlow.onEach {
            try {
                // when (it) {
                // }
            } catch (e: Throwable) {
                mutableErrorState.emit(ErrorState.CommonError(e))
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun getCurrentWeather() {
        mutableViewState.emit(mutableViewState.value.copy(isLoading = false))
    }

    data class ViewState(
        val isLoading: Boolean
    )

    sealed interface ActionState {
    }

    sealed interface ErrorState {
        data class CommonError(
            val error: Throwable
        ) : ErrorState
    }

    sealed interface Action {
    }
}
