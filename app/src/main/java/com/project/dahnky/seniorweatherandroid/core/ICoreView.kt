package com.project.dahnky.seniorweatherandroid.core

import android.support.annotation.IdRes
import android.support.v4.app.Fragment

interface ICoreView {
    fun showProgress()
    fun dismissProgress()
    fun startFragment(@IdRes container: Int, fragment: Fragment,addToBackStack: Boolean)
}