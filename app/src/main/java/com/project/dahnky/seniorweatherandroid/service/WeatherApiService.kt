package com.project.dahnky.seniorweatherandroid.service

import com.project.dahnky.seniorweatherandroid.model.NWSPointsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

public interface WeatherApiService {
    @GET("/points/{latitude},{longitude}")
    fun getNWSPoints(@Path("latitude") latitude: String,
                     @Path("longitude") longitude: String) : Call<NWSPointsResponse>
}
