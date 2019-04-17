package com.project.dahnky.sacweather.view.nav

import dagger.Binds
import dagger.Module

@Module
abstract class DrawerModule {
    @Binds
    abstract fun provideDrawerActivity(drawerActivity: DrawerActivity): DrawerActivity
}