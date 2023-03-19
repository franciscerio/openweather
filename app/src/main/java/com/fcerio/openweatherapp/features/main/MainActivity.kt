package com.fcerio.openweatherapp.features.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.fcerio.module.common.base.BaseViewModelActivity
import com.fcerio.module.common.extensions.setVisible
import com.fcerio.module.common.utils.collectViewModelState
import com.fcerio.module.common.utils.launchWithTimber
import com.fcerio.openweatherapp.R
import com.fcerio.openweatherapp.databinding.ActivityMainBinding
import com.fcerio.openweatherapp.ext.hasLocationPermission
import com.fcerio.openweatherapp.features.location.LocationService
import com.fcerio.openweatherapp.features.location.LocationService.Companion.ACTION_START
import com.fcerio.openweatherapp.features.location.LocationService.Companion.ACTION_STOP
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseViewModelActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            val isOnePermissionDenied = permissions.entries.count { !it.value }
            if (isOnePermissionDenied <= 0) {
                startAndStopServices(ACTION_START)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupPermission()

        setupViews()
        setupVmObservers()
    }

    private fun setupViews() {
        navController().addOnDestinationChangedListener { _, destination, _ ->
            viewModel.onDestinationChanged(destination.id)
        }

        binding.bottomNavigation.apply {
            setupWithNavController(navController())
            setOnItemReselectedListener { /* do nothing */ }
            setOnApplyWindowInsetsListener(null)
        }

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.landingFragment,
                R.id.currentWeatherFragment,
                R.id.currentWeatherListFragment
            ),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )

        with(binding.toolbar.toolbarView) {
            title = ""
            NavigationUI.setupWithNavController(this, navController(), appBarConfiguration)
        }
    }

    private fun setupVmObservers() {
        viewModel
            .state
            .collectViewModelState(this) {
                handleState(it)
            }
    }

    private fun handleState(state: MainState) {
        when (state) {
            MainState.ShowBottomNavigation -> {
                Timber.d("MainState.ShowBottomNavigation")
                binding.bottomNavigation setVisible true
            }
            MainState.HideBottomNavigation -> {
                Timber.d("MainState.HideBottomNavigation")
                binding.bottomNavigation setVisible false
            }
        }
    }


    private fun navigate(navDirections: NavDirections, destinationScreenId: Int) {
        if (navController().currentDestination!!.id != destinationScreenId) {
            navController().navigate(navDirections)
        }
    }

    fun navController() = findNavController(R.id.nav_host_fragment)

    private fun setupPermission() {
        if (hasLocationPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.POST_NOTIFICATIONS
                    )
                )
            } else {
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        } else {
            // continue use the app
            startAndStopServices(ACTION_START)
        }
    }

    override fun onDestroy() {
        startAndStopServices()
        super.onDestroy()
    }

    private fun startAndStopServices(action: String = ACTION_STOP) {
        val intent = Intent(applicationContext, LocationService::class.java)
        intent.action = action
        startService(intent)
    }
}