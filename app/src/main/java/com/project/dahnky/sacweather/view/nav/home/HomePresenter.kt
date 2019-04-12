package com.project.dahnky.sacweather.view.nav.home

import android.util.Log
import com.project.dahnky.sacweather.core.CorePresenter
import com.project.dahnky.sacweather.model.events.NWSForecaseHourlyEvent
import com.project.dahnky.sacweather.service.HomeService
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.threeten.bp.ZonedDateTime
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
    fun onEventReceived(event: NWSForecaseHourlyEvent) {
        // TODO event has been received
        view.hideProgress()
        Log.i("onEventReceived", event.toString())
    }
}