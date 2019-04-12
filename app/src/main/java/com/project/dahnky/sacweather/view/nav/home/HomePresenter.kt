package com.project.dahnky.sacweather.view.nav.home

import android.util.Log
import com.project.dahnky.sacweather.core.CorePresenter
import com.project.dahnky.sacweather.model.events.NWSForecaseHourlyEvent
import com.project.dahnky.sacweather.model.events.NWSPointsEvent
import com.project.dahnky.sacweather.service.HomeService
import com.project.dahnky.sacweather.view.custom.SummaryIcon.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle
import javax.inject.Inject

class HomePresenter @Inject constructor(val view: IHomeView,
                                        val service: HomeService): CorePresenter() {

    fun start() {
        // TODO start
        val today = ZonedDateTime.now()
        view.showProgress()
        service.getHourlyForecast()
    }

    fun refresh() {
        service.getHourlyForecast()
    }

    override fun finish() {
        // service.cancelCall()
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onPointsReceived(event: NWSPointsEvent) {
        EventBus.getDefault().removeStickyEvent(event::class)
        view.hideProgress()
        Log.i("onPointsReceived", event.toString())
        if (event.isSuccess) {
            view.setLocation(event.response?.properties?.relativeLocation?.properties?.city ?: "",
                event.response?.properties?.relativeLocation?.properties?.state ?: "")
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onHourlyForecastReceived(event: NWSForecaseHourlyEvent) {
        // TODO event has been received
        EventBus.getDefault().removeStickyEvent(event::class)
        view.hideProgress()
        Log.i("onHourlyForeReceived", event.toString())
        if (event.isSuccess) {
            ZonedDateTime.now().apply { view.setDate(dateString = this.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withZone(ZoneId.systemDefault()))) }
            event.response?.properties?.periods?.get(0).let { view.setCurrentForecast(forecast = it) }
            event.response?.properties?.periods?.get(0)?.shortForecast?.let { setForecastIcon(shortForecast = it) }
            event.response?.properties?.periods?.subList(1,12)?.let { view.setHourlyForecasts(forecasts = it) }
        }
    }

    private fun setForecastIcon(shortForecast: String) {
        when {
            shortForecast.contains(SNOW.title) -> view.setSummaryIcon(SNOW)
            shortForecast.contains(RAIN.title) -> view.setSummaryIcon(RAIN)
            shortForecast.contains(SUN.title) -> view.setSummaryIcon(SUN)
            shortForecast.contains(CLOUD.title) -> view.setSummaryIcon(CLOUD)
            shortForecast.contains(CLEAR.title) -> view.setSummaryIcon(CLEAR)
        }
    }
}