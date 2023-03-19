package com.fcerio.openweatherapp.features.weather.current

import com.fcerio.module.common.base.BaseFragment
import com.fcerio.module.common.base.BaseStateViewModel
import com.fcerio.module.common.base.BaseViewModelFragment
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.FragmentCurrentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentWeatherFragment : BaseViewModelFragment<FragmentCurrentWeatherBinding, CurrentWeatherViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_current_weather

}