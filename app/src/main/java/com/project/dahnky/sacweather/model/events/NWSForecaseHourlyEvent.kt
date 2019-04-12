package com.project.dahnky.sacweather.model.events

import com.project.dahnky.sacweather.model.NWSGridPointsForecastHourly

data class NWSForecaseHourlyEvent(
    val response: NWSGridPointsForecastHourly? = null,
    val isSuccess: Boolean,
    val error: String = ""
)