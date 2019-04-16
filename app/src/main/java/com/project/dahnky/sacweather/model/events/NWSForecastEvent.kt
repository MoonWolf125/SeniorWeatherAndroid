package com.project.dahnky.sacweather.model.events

import com.project.dahnky.sacweather.model.NWSGridPointsForecast

class NWSForecastEvent(
    val response: NWSGridPointsForecast? = null,
    val isSuccess: Boolean,
    val error: String = "")