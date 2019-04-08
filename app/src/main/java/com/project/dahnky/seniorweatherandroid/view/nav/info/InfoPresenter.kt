package com.project.dahnky.seniorweatherandroid.view.nav.info

import com.project.dahnky.seniorweatherandroid.core.CorePresenter
import com.project.dahnky.seniorweatherandroid.model.ResourceInformation
import com.project.dahnky.seniorweatherandroid.service.ResourcesEvent
import com.project.dahnky.seniorweatherandroid.view.custom.resource.ResourceRowListener
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

// TODO add ResourcesService and the corresponding Module
class InfoPresenter @Inject constructor(val view: IInfoView) : CorePresenter(), ResourceRowListener {

    private val resources: List<ResourceInformation>? = null

    fun start() {
//        service.getResources()
    }

    override fun finish() {
        // service.cancelCall()
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onEventReceived(event: ResourcesEvent) {
        // TODO event has been received
        EventBus.getDefault().removeStickyEvent(event::class.java)
//        view.setResources(event.resources)
    }
}