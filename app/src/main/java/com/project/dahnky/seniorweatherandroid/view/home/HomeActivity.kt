package com.project.dahnky.seniorweatherandroid.view.home

import android.os.Bundle
import android.os.PersistableBundle
import com.project.dahnky.seniorweatherandroid.R
import com.project.dahnky.seniorweatherandroid.core.Coretivity

class HomeActivity : Coretivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_home)
    }
}