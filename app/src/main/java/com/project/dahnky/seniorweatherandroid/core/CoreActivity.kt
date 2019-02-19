package com.project.dahnky.seniorweatherandroid.core

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import dagger.android.support.DaggerAppCompatActivity

abstract class CoreActivity : DaggerAppCompatActivity(), ICoreView {

    override fun showProgress() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissProgress() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startFragment(@IdRes container: Int, fragment: Fragment, addToBackStack: Boolean) {
        if (supportFragmentManager.findFragmentById(container) != null) {
            supportFragmentManager.beginTransaction().apply {
                add(container, fragment)
            }.commit()
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(container, fragment)
                if (addToBackStack)
                    addToBackStack(null)
            }.commit()
        }
    }
}