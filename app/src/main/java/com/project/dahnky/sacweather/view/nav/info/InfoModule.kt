package com.project.dahnky.sacweather.view.nav.info

import dagger.Binds
import dagger.Module

@Module
abstract class InfoModule {
    @Binds
    abstract fun provideInfoFragment(homeFragment: InfoFragment): IInfoView
}