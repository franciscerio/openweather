package com.fcerio.openweatherapp.features.location

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Binder
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.fcerio.module.common.utils.dispatcher.DispatcherProvider
import com.fcerio.openweatherapp.R
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LocationService : Service() {

    @Inject
    lateinit var dispatchers: DispatcherProvider

    private val binder = LocationBinder()

    private val serviceScope by lazy {
        CoroutineScope(SupervisorJob() + dispatchers.io)
    }

    private lateinit var locationClient: LocationClient

    private val mutableLocationSharedFlow: MutableSharedFlow<Location> = MutableSharedFlow()
    val location: SharedFlow<Location> by lazy { mutableLocationSharedFlow.asSharedFlow() }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    inner class LocationBinder : Binder() {
        fun getService(): LocationService = this@LocationService
    }

    override fun onCreate() {
        super.onCreate()
        locationClient = DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(
                applicationContext
            )
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> {
                start()
            }
            ACTION_STOP -> {
                stop()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, "location")
            .setContentTitle("Tracking Location...")
            .setContentText("Location...")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setOngoing(true)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        locationClient.getLocationUpdates(5000L)
            .catch { e -> e.printStackTrace() }
            .onEach {
                val lat = it.latitude.toString().takeLast(3)
                val lon = it.longitude.toString().takeLast(3)
                Timber.d("Location ($lat,$lon)")
                val updateNotification = notification.setContentText(
                    "Location ($lat,$lon)"
                )
                mutableLocationSharedFlow.emit(it)
                notificationManager.notify(1, updateNotification.build())
            }
            .launchIn(serviceScope)

        startForeground(1, notification.build())
    }

    private fun stop() {
        stopForeground(true)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}