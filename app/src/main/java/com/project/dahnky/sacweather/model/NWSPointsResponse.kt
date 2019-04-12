package com.project.dahnky.sacweather.model

data class NWSPointsResponse(
    val id: String?,
    val type: String?,
    val properties: NWSProperties?
)
data class NWSProperties(
    val cwa: String?,
    val gridX: Int,
    val gridY: Int,
    val forecast: String?,
    val forecastHourly: String?,
    val forecastGridData: String?,
    val observationStations: String?,
    val relativeLocation: NWSRelativeLocation?,
    val forecastZone: String?,
    val county: String?,
    val fireWeatherZone: String?,
    val timeZone: String?,
    val radarStation: String?
)

data class NWSRelativeLocation(
    val type: String?,
    val properties: NWSLocationProperties?
)

data class NWSLocationProperties(
    val city: String?,
    val state: String?,
    val distance: NWSValueUnit?,
    val bearing: NWSValueUnit?

)

data class NWSValueUnit(
    val value: Float?,
    val unitCode: String?
)
