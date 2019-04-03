package com.project.dahnky.seniorweatherandroid;

import android.app.Activity;
import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

public class SeniorWeatherAndroid extends Application implements HasActivityInjector {
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }
}
