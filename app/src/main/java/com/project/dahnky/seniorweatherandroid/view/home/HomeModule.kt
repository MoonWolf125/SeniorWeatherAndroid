package com.project.dahnky.seniorweatherandroid.view.home

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private var activity: Activity) {
    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}