package com.project.dahnky.seniorweatherandroid.view.home

import android.os.Bundle
import com.project.dahnky.seniorweatherandroid.R
import com.project.dahnky.seniorweatherandroid.core.CoreActivity
import kotlinx.android.synthetic.main.content_temperature_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

class HomeActivity : CoreActivity<HomePresenter>(), IHomeView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        setupToolbar()
        init()
    }

    fun init() {
        tv_date.text = Calendar.getInstance().toString()
    }

    fun setupToolbar() {
        toolbar.title = "Fargo - Test"
    }
}