package com.project.dahnky.sacweather.model

data class NWSGridPointsForecastHourly(
    val type: String?,
    val properties: NWSForeHourlyProperties?
)

data class NWSForeHourlyProperties(
    val updated: String?,
    val units: String?,
    val forecastGenerator: String?,
    val generatedAt: String?,
    val updateTime: String?,
    val validTimes: String?,
    val elevation: NWSValueUnit?,
    val periods: List<NWSForeHourlyPeriod>
)

data class NWSForeHourlyPeriod(
    val number: Int?,
    val name: String?,
    val startTime: String?,
    val endTime: String?,
    val isDayTime: Boolean,
    val temperature: Int,
    val temperatureUnit: String?,
    val temperatureTrend: String?,
    val windSpeed: String?,
    val windDirection: String?,
    val icon: String?,
    val shortForecast: String?,
    val detailedForecast: String?
)
