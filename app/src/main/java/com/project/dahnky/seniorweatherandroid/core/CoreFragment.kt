package com.project.dahnky.seniorweatherandroid.core

import android.support.v4.app.Fragment
import javax.inject.Inject

abstract class CoreFragment<E: CorePresenter> : Fragment(), ICoreView {

    @Inject
    protected lateinit var presenter: E

    // Kotlin Getters and Setters
    private val coretivity: ICoreView
        get() = context as ICoreView
//        set(value) { context = value }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.finish()
        super.onDestroy()
    }

    override fun backNavigation() {
        coretivity.backNavigation()
    }

    override fun displayDialog(title: String, content: String) {
        coretivity.displayDialog(title = title, content = content)
    }

    override fun startFragment(container: Int, fragment: Fragment, addToBackStack: Boolean) {
        coretivity.startFragment(container = container, fragment = fragment, addToBackStack = addToBackStack)
    }
}