package com.project.dahnky.sacweather.core

import org.greenrobot.eventbus.EventBus

abstract class CorePresenter {

    open fun onResume() {
        EventBus.getDefault().register(this)
    }

    open fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    abstract fun finish()
}