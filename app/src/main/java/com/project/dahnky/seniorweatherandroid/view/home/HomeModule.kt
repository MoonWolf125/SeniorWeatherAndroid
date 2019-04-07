package com.project.dahnky.seniorweatherandroid.view.home

import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {
    @Binds
    abstract fun provideHomeActivity(homeFragment: HomeFragment): IHomeView
}