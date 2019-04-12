package com.project.dahnky.sacweather.model

data class NWSPointsResponse(
    val id: String?,
    val type: String?,
    val geometry: NWSGeometry?,
    val properties: NWSProperties?
)

data class NWSGeometry(
    val type: String?,
    val coordinates: NWSPoint?
)

data class NWSPoint(
    val longitude: Float,
    val latitude: Float
)

data class NWSProperties(
    val cwa: String?,
    val gridX: Int,
    val gridY: Int,
    val forecast: String?,
    val forecastHourly: String?,
    val forecastGridData: String?,
    val observationStations: String?
)
