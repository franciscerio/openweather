package com.fcerio.openweatherapp.features.main

sealed class MainState {
    object ShowBottomNavigation : MainState()

    object HideBottomNavigation : MainState()
}
