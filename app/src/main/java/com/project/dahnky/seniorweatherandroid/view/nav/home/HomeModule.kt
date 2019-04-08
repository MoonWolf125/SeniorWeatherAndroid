package com.project.dahnky.seniorweatherandroid.view.nav.home

import dagger.Binds
import dagger.Module

@Module
abstract class HomeModule {
    @Binds
    abstract fun provideHomeFragment(homeFragment: HomeFragment): IHomeView
}