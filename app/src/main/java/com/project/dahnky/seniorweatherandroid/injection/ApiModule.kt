/*
* Used: https://android.jlelse.eu/7-steps-to-implement-dagger-2-in-android-dabc16715a3a
*/

package com.project.dahnky.seniorweatherandroid.injection

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.project.dahnky.seniorweatherandroid.service.EmbeddedApiService
import com.project.dahnky.seniorweatherandroid.service.WeatherApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    private val NWS_API_URL = "https://api.weather.gov"
    private val PI_API_URL = ""

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .serializeNulls()
            .create()
    }

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        return Cache(File(application.cacheDir, "http-cache"), 10 * 1024 * 1024)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder()
            .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(retrofit: Retrofit.Builder): WeatherApiService {
        return retrofit.baseUrl(NWS_API_URL)
            .build()
            .create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesEmbeddedApiService(retrofit: Retrofit.Builder): EmbeddedApiService {
        return retrofit.baseUrl(PI_API_URL)
            .build()
            .create(EmbeddedApiService::class.java)
    }
}