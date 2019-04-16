package com.project.dahnky.sacweather.model.events

import com.project.dahnky.sacweather.model.NWSPointsResponse

data class NWSPointsEvent(
    val response: NWSPointsResponse? = null,
    val isSuccess: Boolean,
    val error: String = "")
