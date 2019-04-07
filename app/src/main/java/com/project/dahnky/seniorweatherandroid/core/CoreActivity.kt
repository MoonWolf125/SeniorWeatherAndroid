package com.project.dahnky.seniorweatherandroid.core

import android.os.Bundle
import android.os.PersistableBundle
import javax.inject.Inject

abstract class CoreActivity<E: CorePresenter> : BaseActivity() {

    @Inject protected lateinit var presenter: E

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        if (isFinishing)
            presenter.finish()
        super.onDestroy()
    }
}