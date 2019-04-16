/*
* Used: https://android.jlelse.eu/7-steps-to-implement-dagger-2-in-android-dabc16715a3a
*/
package com.project.dahnky.sacweather.injection

import android.app.Application
import android.content.Context
import com.project.dahnky.sacweather.SACWeather
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        ModuleBuilder::class
    ]
)

@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: SACWeather): Builder

        fun build(): AppComponent
    }

    fun inject(seniorWeatherAndroid: SACWeather)
}

@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideApp(seniorWeatherAndroid: SACWeather): Application

    @Singleton
    @Binds
    abstract fun provideContext(seniorWeatherAndroid: SACWeather): Context
}