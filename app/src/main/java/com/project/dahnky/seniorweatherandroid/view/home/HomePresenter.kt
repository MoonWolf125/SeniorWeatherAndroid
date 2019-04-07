package com.project.dahnky.seniorweatherandroid.view.home

import com.project.dahnky.seniorweatherandroid.core.CorePresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(val view: IHomeView): CorePresenter() {
    override fun finish() {
        // service.cancelCall()
    }

}