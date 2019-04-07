package com.project.dahnky.seniorweatherandroid.view.home

import android.os.Bundle
import com.project.dahnky.seniorweatherandroid.R
import com.project.dahnky.seniorweatherandroid.core.CoreActivity

class HomeActivity : CoreActivity<HomePresenter>(), IHomeView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        setupToolbar()
    }
}