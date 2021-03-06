package com.project.dahnky.sacweather.service

import com.project.dahnky.sacweather.model.NWSGridPoints
import com.project.dahnky.sacweather.model.NWSGridPointsForecast
import com.project.dahnky.sacweather.model.NWSGridPointsForecastHourly
import com.project.dahnky.sacweather.model.NWSPointsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

public interface WeatherApiService {
    @GET("/points/{latitude},{longitude}")
    fun getNWSPoints(@Path("latitude") latitude: String,
                     @Path("longitude") longitude: String) : Call<NWSPointsResponse>

    @GET("/gridpoints/{wfo}/{x},{y}")
    fun getNWSGridpoints(@Path("wfo") Office: String,
                        @Path("x") xAxis: Int,
                        @Path("y") yAxis: Int) : Call<NWSGridPoints>

    @GET("/gridpoints/{wfo}/{x},{y}/forecast")
    fun getNWSGridpointsForecast(@Path("wfo") Office: String,
                                 @Path("x") xAxis: Int,
                                 @Path("y") yAxis: Int) : Call<NWSGridPointsForecast>

    @GET("/gridpoints/{wfo}/{x},{y}/forecast/hourly")
    fun getNWSGridpointsForecastHourly(@Path("wfo") Office: String,
                                       @Path("x") xAxis: Int,
                                       @Path("y") yAxis: Int) : Call<NWSGridPointsForecastHourly>
}
