package com.project.dahnky.sacweather.view.nav.home

import com.project.dahnky.sacweather.core.ICoreView
import com.project.dahnky.sacweather.model.NWSForecastPeriod
import com.project.dahnky.sacweather.view.custom.ForecastSelection
import com.project.dahnky.sacweather.view.custom.SummaryIcon

interface IHomeView: ICoreView {

    fun showProgress()
    fun hideProgress()
    fun setLocation(city: String, state: String)
    fun setDate(dateString: String)
    fun setCurrentForecast(forecast: NWSForecastPeriod?)
    fun setSummaryIcon(summaryIcon: SummaryIcon)
    fun setForecasts(forecasts: List<NWSForecastPeriod>, forecastSelection: ForecastSelection): Boolean
}
