package com.louiefloresca.mvpdaggerexample;

import android.app.Application;

import com.louiefloresca.mvpdaggerexample.di.component.ApplicationComponent;
import com.louiefloresca.mvpdaggerexample.di.component.DaggerApplicationComponent;
import com.louiefloresca.mvpdaggerexample.di.module.ApplicationModule;

public class MvpDaggerApp extends Application  {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
