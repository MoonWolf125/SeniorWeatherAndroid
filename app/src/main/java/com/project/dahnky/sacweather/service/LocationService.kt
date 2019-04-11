package com.project.dahnky.sacweather.service

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.util.Log
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext

@Singleton
class HomeService @Inject constructor(private val context: Context): LocationCallback() {
    private enum class WeatherRequest {
        Hourly,
        Daily
    }

    private var weatherRequest = WeatherRequest.Hourly

    fun getHourlyForecast() {
        val locationRequest = LocationRequest()
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(locationRequest, this, null)
            weatherRequest = WeatherRequest.Hourly
        }
    }

    fun getDailyForecase() {
        val locationRequest = LocationRequest()
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(locationRequest, this, null)
            weatherRequest = WeatherRequest.Daily
        }
    }

    override fun onLocationResult(result: LocationResult?) {
        super.onLocationResult(result)
        if (result?.lastLocation != null) {
            Log.i("onLocationResult", "Latitude: " + result.lastLocation.latitude.toString() + ", " + "Longitude: " + result.lastLocation.longitude.toString())
        }
    }
}