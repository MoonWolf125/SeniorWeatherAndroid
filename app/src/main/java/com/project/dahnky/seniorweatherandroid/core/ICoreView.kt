package com.project.dahnky.seniorweatherandroid.core

import android.support.annotation.IdRes
import android.support.v4.app.Fragment

interface ICoreView {
    fun startFragment(@IdRes container: Int, fragment: Fragment,addToBackStack: Boolean)
    fun backNavigation()
    fun displayDialog(title: String, content: String, enableRetry: Boolean)
}