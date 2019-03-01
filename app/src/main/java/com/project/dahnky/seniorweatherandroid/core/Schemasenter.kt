package com.project.dahnky.seniorweatherandroid.core

import org.greenrobot.eventbus.EventBus

abstract class Schemasenter {

    private lateinit var view: ICore

    fun onResume() {
        EventBus.getDefault().register(this)
    }

    fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    abstract fun finish()
}