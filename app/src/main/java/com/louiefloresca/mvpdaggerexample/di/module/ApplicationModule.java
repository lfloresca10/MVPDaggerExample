package com.louiefloresca.mvpdaggerexample.di.module;

import android.app.Application;
import android.content.Context;

import com.louiefloresca.mvpdaggerexample.di.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @ApplicationContext
    @Provides
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
