package com.project.dahnky.seniorweatherandroid.injection

import com.project.dahnky.seniorweatherandroid.view.home.HomeActivity
import com.project.dahnky.seniorweatherandroid.view.home.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ModuleBuilder {
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeActivityInjector(): HomeActivity
}