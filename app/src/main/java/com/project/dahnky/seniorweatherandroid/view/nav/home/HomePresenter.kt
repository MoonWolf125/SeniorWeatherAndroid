package com.project.dahnky.seniorweatherandroid.view.nav.home

import com.project.dahnky.seniorweatherandroid.core.CorePresenter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class HomePresenter @Inject constructor(val view: IHomeView): CorePresenter() {

    fun start() {
        // TODO start
    }

    override fun finish() {
        // service.cancelCall()
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onEventReceived(event: Any) {
        // TODO event has been received
    }

}