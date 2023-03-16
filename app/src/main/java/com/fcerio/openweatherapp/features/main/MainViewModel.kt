package com.fcerio.openweatherapp.features.main

import androidx.lifecycle.viewModelScope
import com.fcerio.module.common.base.BaseViewModel
import com.fcerio.module.common.utils.launchWithTimber
import com.fcerio.openweatherapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : BaseViewModel() {

    private val _state = MutableSharedFlow<MainState>()

    val state: Flow<MainState> = _state

    private val bottomNavDestinationIds by lazy {
        arrayOf(
            R.id.currentWeatherFragment,
            R.id.currentWeatherListFragment
        )
    }

    private val backNavigationIds by lazy {
        setOf(
            R.id.signInFragment,
            R.id.registrationFragment
        )
    }

    fun onDestinationChanged(destinationId: Int) {
        handleBottomNavigation(destinationId)
    }

    fun handleBackNavigationIds() {

    }

    private fun handleBottomNavigation(destinationId: Int) {
        viewModelScope.launchWithTimber {
            when (destinationId) {
                in bottomNavDestinationIds -> {
                    _state
                        .emit(
                            MainState.ShowBottomNavigation
                        )
                }
                else -> {
                    _state
                        .emit(
                            MainState.HideBottomNavigation
                        )
                }
            }
        }
    }

    fun testing() {
        viewModelScope.launchWithTimber {
            _state
                .emit(
                    MainState.HideBottomNavigation
                )
        }
    }
}