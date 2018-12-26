package com.louiefloresca.mvpdaggerexample.di.component;

import android.app.Application;
import android.content.Context;

import com.louiefloresca.mvpdaggerexample.MvpDaggerApp;
import com.louiefloresca.mvpdaggerexample.api.APIInterface;
import com.louiefloresca.mvpdaggerexample.di.module.ApplicationModule;
import com.louiefloresca.mvpdaggerexample.di.module.RetrofitModule;
import com.louiefloresca.mvpdaggerexample.di.qualifier.ApplicationContext;
import com.louiefloresca.mvpdaggerexample.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    void inject(MvpDaggerApp app);

    @ApplicationContext
    Context getContext();

    Application application();

    APIInterface getApiInterface();


}
