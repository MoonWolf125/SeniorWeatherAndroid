package com.project.dahnky.seniorweatherandroid.core

abstract class Schemativity<E: Schemasenter> : Coretivity() {

    protected lateinit var presenter: E

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