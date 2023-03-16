package com.fcerio.openweatherapp.features.weather.list

import androidx.databinding.ViewDataBinding
import com.fcerio.module.common.base.BaseFragment
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentCurrentWeatherListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherListFragment : BaseFragment<FragmentCurrentWeatherListBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_current_weather_list
}