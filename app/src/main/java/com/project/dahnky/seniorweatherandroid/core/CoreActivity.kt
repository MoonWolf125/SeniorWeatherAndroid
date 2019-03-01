package com.project.dahnky.seniorweatherandroid.core

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import dagger.android.support.DaggerAppCompatActivity

abstract class CoreActivity : DaggerAppCompatActivity(), ICoreView {

    override fun startFragment(@IdRes container: Int, fragment: Fragment, addToBackStack: Boolean) {
        if (supportFragmentManager.findFragmentById(container) != null)
            supportFragmentManager.beginTransaction().apply {
                add(container, fragment)
            }.commit()
        else
            supportFragmentManager.beginTransaction().apply {
                replace(container, fragment)
                if (addToBackStack)
                    addToBackStack(null)
            }.commit()
    }

    override fun backNavigation() {
        if (supportFragmentManager.backStackEntryCount != 0)
            supportFragmentManager.apply { popBackStack() }
        else
            apply { finish() }
    }

    override fun displayErrorDialog(content: String, enableRetry: Boolean) {
        MaterialDialog(this).show {
            title(text = "Error")
            message(text = content)
        }
    }
}