/*
* Used: https://android.jlelse.eu/7-steps-to-implement-dagger-2-in-android-dabc16715a3a
*/
package com.project.dahnky.seniorweatherandroid.injection

import android.app.Application
import com.project.dahnky.seniorweatherandroid.SeniorWeatherAndroid
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
        fun application(application: SeniorWeatherAndroid): Builder

        fun build(): AppComponent
    }

    fun inject(seniorWeatherAndroid: SeniorWeatherAndroid)
}

@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideApp(seniorWeatherAndroid: SeniorWeatherAndroid): Application
}