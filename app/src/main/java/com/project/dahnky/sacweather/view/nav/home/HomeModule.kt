package com.project.dahnky.sacweather.view.nav.home

import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {
    @Binds
    abstract fun provideHomeFragment(homeFragment: HomeFragment): IHomeView
}