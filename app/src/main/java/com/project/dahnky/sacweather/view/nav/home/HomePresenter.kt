package com.project.dahnky.sacweather.view.nav.home

import com.project.dahnky.sacweather.core.CorePresenter
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
        service.getHourlyForecast()
    }

    override fun finish() {
        // service.cancelCall()
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onEventReceived(event: Any) {
        // TODO event has been received
    }
}