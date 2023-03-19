package com.fcerio.openweatherapp.features.weather.current

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import com.fcerio.module.common.base.BaseViewModelFragment
import com.fcerio.module.common.utils.launchWithTimber
import com.fcerio.module.common.utils.viewLifecycleScope
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentCurrentWeatherBinding
import com.fcerio.openweatherapp.features.location.LocationService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherFragment :
    BaseViewModelFragment<FragmentCurrentWeatherBinding, CurrentWeatherViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_current_weather

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}