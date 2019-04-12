package com.project.dahnky.sacweather.view.nav.home

import com.project.dahnky.sacweather.core.ICoreView
import com.project.dahnky.sacweather.model.NWSForeHourlyPeriod
import com.project.dahnky.sacweather.view.custom.SummaryIcon

interface IHomeView: ICoreView {
    companion object {
        enum class ForecastSelection {
            HOURLY,
            DAILY
        }
    }

    fun showProgress()
    fun hideProgress()
    fun setLocation(city: String, state: String)
    fun setDate(dateString: String)
    fun setCurrentForecast(forecast: NWSForeHourlyPeriod?)
    fun setSummaryIcon(icon: SummaryIcon)
    fun setHourlyForecasts(forecasts: List<NWSForeHourlyPeriod>): Boolean
}
