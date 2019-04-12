package com.project.dahnky.sacweather.model

data class NWSGridPointsForecast(
    val type: String?,
    val geometry: NWSGridPointsGeometry?,
    val properties: NWSGridPointsProperties?
)

data class NWSGridPointsGeometry(
    val type: String?
)

data class NWSGridPointsProperties(
    val updated: String?,
    val units: String?,
    val forecastGenerator: String?,
    val generatedAt: String?,
    val updateTime: String?,
    val validTimes: String?,
    val elevation: NWSValueUnit?,
    val periods: List<NWSForecastPeriod>
)
