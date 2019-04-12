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
import com.project.dahnky.sacweather.model.NWSGridPointsForecastHourly
import com.project.dahnky.sacweather.model.NWSPointsResponse
import com.project.dahnky.sacweather.model.events.NWSForecaseHourlyEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Response
import kotlin.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeService @Inject constructor(private val context: Context, private val weatherService: WeatherService): LocationCallback() {
    private enum class WeatherRequest {
        Hourly,
        Daily
    }

    private var weatherRequest = WeatherRequest.Hourly

    fun getHourlyForecast() {
        val locationRequest = LocationRequest()
        weatherRequest = WeatherRequest.Hourly
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(locationRequest, this, null)
        } else {
            // call getNWS stuff here but using the static MSUM Lat/Long
            weatherService.getNWSGridpointsForecastHourly((46.867758).toString(), (-96.758283).toString())
        }
    }

    fun getDailyForecast() {
        val locationRequest = LocationRequest()
        weatherRequest = WeatherRequest.Daily
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(locationRequest, this, null)
        } else {
            // TODO call getNWS stuff here but using the static MSUM CMU Lat/Long
        }
    }

    override fun onLocationResult(result: LocationResult?) {
        super.onLocationResult(result)
        if (result?.lastLocation != null) {
            when (weatherRequest) {
                WeatherRequest.Hourly -> weatherService.getNWSGridpointsForecastHourly(result.lastLocation.latitude.toString(), result.lastLocation.longitude.toString())
                WeatherRequest.Daily -> TODO()
            }
            Log.i("onLocationResult", "Latitude: ${result.lastLocation.latitude}, Longitude: ${result.lastLocation.longitude}")
        }
    }
}

@Singleton
class WeatherService @Inject constructor(private val apiService: WeatherApiService) {
    fun getNWSGridpointsForecastHourly(latitude: String, longitude: String) {
        val points = getNWSPoints(latitude, longitude)
        if (points != null) {
            val res: Response<NWSGridPointsForecastHourly> = apiService.getNWSGridpointsForecastHourly(points.properties?.cwa!!, points.properties.gridX, points.properties.gridY).execute()
            if (res.isSuccessful) {
                EventBus.getDefault().postSticky(NWSForecaseHourlyEvent(res.body()!!, isSuccess = true))
            } else {
                EventBus.getDefault().postSticky(NWSForecaseHourlyEvent(isSuccess = false, error = res.message()))
            }
        }
    }

    private fun getNWSPoints(latitude: String, longitude: String): NWSPointsResponse? {
        val res: Response<NWSPointsResponse> = apiService.getNWSPoints(latitude, longitude).execute()
        if (res.isSuccessful) {
            return res.body()!!
        }
        return null
    }
}