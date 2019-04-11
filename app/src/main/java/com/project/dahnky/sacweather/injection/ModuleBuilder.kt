package com.project.dahnky.sacweather.injection

import com.project.dahnky.sacweather.view.nav.home.HomeFragment
import com.project.dahnky.sacweather.view.nav.home.HomeModule
import com.project.dahnky.sacweather.view.nav.DrawerActivity
import com.project.dahnky.sacweather.view.nav.DrawerModule
import com.project.dahnky.sacweather.view.nav.info.InfoFragment
import com.project.dahnky.sacweather.view.nav.info.InfoModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ModuleBuilder {
    @ContributesAndroidInjector(modules = [DrawerModule::class])
    abstract fun drawerActivityInject(): DrawerActivity

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeFragmentInjector(): HomeFragment

    @ContributesAndroidInjector(modules = [InfoModule::class])
    abstract fun infoFragmentInjector(): InfoFragment
}