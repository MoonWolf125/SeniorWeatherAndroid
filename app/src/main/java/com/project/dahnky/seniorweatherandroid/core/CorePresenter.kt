package com.project.dahnky.seniorweatherandroid.core

import org.greenrobot.eventbus.EventBus

abstract class CorePresenter {

    private lateinit var view: ICoreView

    open fun onResume() {
        EventBus.getDefault().register(this)
    }

    open fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    abstract fun finish()
}