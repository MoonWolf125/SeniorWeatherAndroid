package com.project.dahnky.seniorweatherandroid.view.nav

import dagger.Binds
import dagger.Module

@Module
abstract class DrawerModule {
    @Binds
    abstract fun provideDrawerActivity(drawerActivity: DrawerActivity): DrawerActivity
}