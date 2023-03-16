package com.fcerio.openweatherapp.features.weather.current

import com.fcerio.module.common.base.BaseFragment
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentCurrentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherFragment : BaseFragment<FragmentCurrentWeatherBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_current_weather

}